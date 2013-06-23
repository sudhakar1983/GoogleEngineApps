package com.sudhakar.notesoneffectivejava;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;
import com.sudhakar.notesoneffectivejava.model.Note;



/**
 * The Class NoteSetup.
 *
 * @author Sudhakar Duraiswamy
 * The Class NoteSetup.
 */
@SuppressWarnings("serial")
public class NoteSetup extends HttpServlet{

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(NoteSetup.class.getName());
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
/*		PrintWriter pw = resp.getWriter();
		pw.write("Setup Get not supported");*/
		req.getRequestDispatcher("setup.jsp").forward(req, resp);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pp = req.getParameter("pp");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String order = (null != req.getParameter("order") ? req.getParameter("order") : "1");

		if(null != pp  && "letusrock".equals(pp)){
			
			
			if (null != title && !title.trim().equals("") && null != description && !description.trim().equals("")) {
				Note note = new Note();
				note.setTitle(title);
				note.setDescription(new Text(description));
				note.setOrd(Integer.parseInt(order));
				logger.log(Level.INFO, note.toString());
				
				EntityManager em = null;
				try {
					em = EMF.getEntityManager();
					em.getTransaction().begin();
					em.persist(note);

					em.getTransaction().commit();
				} catch (Exception e) {					
					e.printStackTrace();
				}
				
			}
			
		}
		
		req.setAttribute("result", true);
		req.getRequestDispatcher("setup.jsp").forward(req, resp);
/*		PrintWriter writer = resp.getWriter();  	    
		writer.write("inserted:\n"); */ 

	}
}
