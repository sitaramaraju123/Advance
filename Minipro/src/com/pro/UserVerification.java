package com.pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserVerification extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("uname");
	String email=req.getParameter("email");
	String phone = req.getParameter("phone");
	String dob = req.getParameter("dob");
	String pwd = req.getParameter("pwd");
	String cpwd=req.getParameter("c_pwd");
	 if(pwd.equals(cpwd)) {
		 String code = getRandom();
			
			String toemail = email;
			String fromemail="sitaramaraju123463@gmail.com";
			String password = "ramaraju2143";
			
			try {
				 Properties props = new Properties();    
		          props.put("mail.smtp.host", "smtp.gmail.com");    
		          props.put("mail.smtp.socketFactory.port", "465");    
		          props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
		          props.put("mail.smtp.auth", "true");    
		        //  props.put("mail.smtp.port", "465");     
		          Session session = Session.getDefaultInstance(props,new Authenticator() {    
		                  protected PasswordAuthentication getPasswordAuthentication() {    
		                  return new PasswordAuthentication(fromemail, password);  
		                  }    
		                 });
		          
		          MimeMessage  msg = new  MimeMessage(session);
		          msg.setFrom(new InternetAddress(fromemail));
		          msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
		          msg.setSubject("User Email Verification");
		          msg.setText("Verify your Account using this Code: "+code);
		          Transport.send(msg);
		          
		          HttpSession session1=req.getSession();  
			        session1.setAttribute("authcode",code);
			        session1.setAttribute("name",name);
			        session1.setAttribute("email",email);
			        session1.setAttribute("phone",phone);
			        session1.setAttribute("dob",dob);
			        session1.setAttribute("pwd",pwd);
			        session1.setAttribute("cpwd",cpwd);
			        resp.sendRedirect("Verifycode.html");
			        
			}catch(Exception e) {
				resp.setContentType("text/html");
				resp.sendRedirect("Register.html");
			}
			
	 }else {
		 PrintWriter out = resp.getWriter();
		 resp.setContentType("text/html");
			out.print("<p>Your password And conform password must be Same..</p>");
			RequestDispatcher dp = req.getRequestDispatcher("Register.html");
			dp.include(req, resp); 
	 }
	
	
}

public static String getRandom() {
	Random rnd = new Random();
	int num = rnd.nextInt(999999);
	return String.format("%06d", num);
}
}
