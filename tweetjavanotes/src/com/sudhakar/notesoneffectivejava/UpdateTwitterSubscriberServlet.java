package com.sudhakar.notesoneffectivejava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.sudhakar.notesoneffectivejava.model.TwiJavaNotes;


/**
 * The Class UpdateTwitterSubscriberServlet.
 *
 * @author Sudhakar Duraiswamy
 * The Class UpdateTwitterSubscriberServlet.
 */
public class UpdateTwitterSubscriberServlet extends HttpServlet{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4902344782539736882L;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(UpdateTwitterSubscriberServlet.class.getName());

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

/*
		if (req.getHeader("X-AppEngine-Cron") == null) {
			return;
		}*/
		
		//Get Twitter Instance
		Twitter  twitter = TwitterFactory.getSingleton();
		try {
			IDs followersIDs = twitter.getFollowersIDs(-1);
			Key key = KeyFactory.createKey(TwiJavaNotes.class.getSimpleName(), "twitter");
			
			List<Long> idList = new ArrayList<Long>();
			for (long id : followersIDs.getIDs()) { 
				System.out.println(id);
				idList.add(id);
			}
			EntityManager em =  EMF.getEntityManager();
			try {
				
				em.getTransaction().begin();
				
				TwiJavaNotes subscribers;
				try {
					subscribers = null;
					Query query= 	em.createQuery("select from TwiJavaNotes twi where key=?1");
					query.setParameter(1, key);				
					subscribers = (TwiJavaNotes) query.getSingleResult();
				} catch (Exception e) {
					subscribers = null;
				}
				
				if(null != subscribers){
					subscribers.setFollowers(idList);					
				}else{
					subscribers = new TwiJavaNotes();
					subscribers.setKey(key);
					subscribers.setFollowers(idList);
					subscribers.setNextNoteId(1);
				}
				em.persist(subscribers);
				em.getTransaction().commit();
				
				//Fetch Twitter Subscriber list from DB
				subscribers = null;
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Entitymanager exception!!",e);
				em.getTransaction().rollback();
				resp.setContentType("text/html");
				resp.getWriter().print("Twitter Subscriber list updated FAILED !!.");
			}			
			logger.log(Level.INFO, "Key Generated : "+key);
			
			
			resp.setContentType("text/html");
			resp.getWriter().print("Twitter Subscriber list updated for app : Effective Java");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setContentType("text/html");
			resp.getWriter().print("Twitter Subscriber list updated FAILED !!.");		
			
			
		}
		
		
	}
	

}
