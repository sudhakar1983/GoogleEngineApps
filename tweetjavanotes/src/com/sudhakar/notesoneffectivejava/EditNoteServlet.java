package com.sudhakar.notesoneffectivejava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;
import com.sudhakar.notesoneffectivejava.model.Note;




/**
 * The Class EditNoteServlet.
 * 
 *  Edit Notes
 *
 * @author Sudhakar Duraiswamy
 */
public class EditNoteServlet extends HttpServlet{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5323257868886268447L;
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(EditNoteServlet.class.getName());
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean isFound = false;
		System.out.println("do get method");
		logger.info("doGet method ");
		
		String noteId = req.getParameter("id");
		if(null!= noteId && !noteId.trim().equals("")){
			EntityManager em = null;
			try {
				em = EMF.getEntityManager();
				em.getTransaction().begin();
				Query q = em.createQuery("select from Note note where note.id="+noteId);
				
				
				Note note = (Note) q.getSingleResult();
				if(null != note ) isFound = true;
				
				req.setAttribute("note", note);
				em.getTransaction().commit();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(isFound){
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}else{
			PrintWriter pw = resp.getWriter();
			pw.print("Note not found !!!");
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		logger.info("Post method ");
		System.out.println("do post method - sudhakar");
		
		
		boolean isFound = false;
		
		
		String pp = req.getParameter("pp");
		String noteId = req.getParameter("noteid");
		String title = req.getParameter("title");
		String description = (null != req.getParameter("description") ? req.getParameter("description") : "");
		String order = (null != req.getParameter("order") ? req.getParameter("order") : "1");

		if(null != pp  && "letusrock".equals(pp)){
			
			if (null != title && !title.trim().equals("") && null != noteId && !noteId.trim().equals("")) {
				EntityManager em = null;
				try {
					
					em = EMF.getEntityManager();
					em.getTransaction().begin();
					System.out.println("firing query");
					Query q = em.createQuery("select from Note note where note.id="+noteId);
										
					Note note = (Note) q.getSingleResult();
					if(null != note ) isFound = true;
					System.out.println("note found :"+note.getId());
					
					note.setTitle(title);
					note.setDescription(new Text(description));
					note.setOrd(Integer.parseInt(order));
					
					em.getTransaction().commit();
					
/*					em = EMF.getEntityManager();
					em.persist(note);
					em.getTransaction().commit();
*/					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}	
		
		String status ="";
		if(isFound){
			status="Edit Success!!";
		}else{
			status="Edit Failed!!";
		}
		
		PrintWriter pw = resp.getWriter();
		pw.print(status);

	}
	
	
	
}
