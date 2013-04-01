package com.sudhakar.notesoneffectivejava;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FeedbackServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String name = req.getParameter("name");
		String feedback = req.getParameter("feedback");
		String email = req.getParameter("email");
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = name + "\n" + feedback + "\n" + email;

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("sudhakar.duraiswamy@gmail.com",	"Effective Java App"));
			
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(	email ));
			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(	email ));
			msg.setSubject("Feedback");
			msg.setText(msgBody);
			Transport.send(msg);

		} catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);			
			resp.setContentType("text/plain");
			resp.getWriter().println("Something went wrong. Please try again.");
			throw new RuntimeException(e);
		}

		resp.setContentType("text/plain");
		resp.getWriter().println(
		"Thank you for your feedback. A copy is sent to your email for your reference.");
	}
}