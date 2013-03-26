package com.sudhakar.notesoneffectivejava;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sudhakar.notesoneffectivejava.model.Note;


/**
 * The Class MyNotesOnEffective_JavaServlet.
 *
 * @author Sudhakar Duraiswamy
 * The Class MyNotesOnEffective_JavaServlet.
 */
@SuppressWarnings("serial")
public class MyNotesOnEffective_JavaServlet extends HttpServlet {
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String view = "/list.jsp";
		String noteId = req.getParameter("id");
		System.out.println("noteId param :"+noteId);
		EntityManager em = null;
		try {
			em = EMF.getEntityManager();
			em.getTransaction().begin();
			Query q = em.createQuery("select from Note note");
			@SuppressWarnings("unchecked")
			List<Note> list = q.getResultList();
			System.out.println("list size fetched :"+ list.size());
			
			req.setAttribute("notes", list);
			if(null!= noteId && !noteId.trim().equals("")){
				try {
					int id = Integer.parseInt(noteId);
					req.setAttribute("noteid", id);
					view=view+"#des"+id;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			em.getTransaction().commit();
			
			req.getRequestDispatcher(view).forward(req, resp);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Something bad happened. Please shoot a mail to sudhakarbe@gmail.com");
		
	}
}
