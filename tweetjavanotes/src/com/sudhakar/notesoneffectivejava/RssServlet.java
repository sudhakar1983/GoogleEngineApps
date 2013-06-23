package com.sudhakar.notesoneffectivejava;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sudhakar.notesoneffectivejava.model.Note;
import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;



/**
 * The Class RssServlet.
 *
 *  - data exposed as RSS.
 * @author Sudhakar Duraiswamy
 */
@SuppressWarnings("serial")
public class RssServlet  extends HttpServlet {
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManager em = EMF.getEntityManager();

		
		response.setContentType("text/xml");		
		Writer writer = response.getWriter();
		
		
		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType("rss_2.0"); 
		feed.setTitle("Notification"); 
		feed.setLink("http://twittereffectivejava.appspot.com/rss");
		feed.setDescription("Effective Java Notes - Everyday Health Pill for Java Developers....");
		feed.setAuthor("Sudhakar Duraiswamy");
		
		List<SyndCategory> entryCategories = new ArrayList<SyndCategory>();
		SyndCategory category = new SyndCategoryImpl();
		category.setName("Java");
		
		SyndCategory category1 = new SyndCategoryImpl();
		category1.setName("Effective Java");
		entryCategories.add(category1);
		feed.setCategories(entryCategories);
		
		List<SyndEntry> entryList = new ArrayList<SyndEntry>();
		Query q = em.createQuery("select from Note note");
		@SuppressWarnings("unchecked")
		List<Note> notes = q.getResultList();
		
		for(Note note :notes){
			
			SyndEntry entry = new SyndEntryImpl(); 
			entry.setTitle("NotificationId:"+note.getTitle()); 
			entry.setLink("");
			entry.setPublishedDate(new Date()) ;
					
			SyndContent description = new SyndContentImpl();
			description.setType("text/html");
			description.setValue("<p>" +					
					"<b>Notification Description</b>: <p>"+note.getDescription()+"</p>" +
					"</p>");
			entry.setDescription(description);
			

			entry.setCategories(entryCategories);
			entryList.add(entry);			
		}
		
		
		feed.setEntries(entryList);
        SyndFeedOutput output = new SyndFeedOutput(); 
        try {
			output.output(feed,writer);
		} catch (FeedException e) {
			
			e.printStackTrace();
		} 
		writer.close();		
		
	}

}
