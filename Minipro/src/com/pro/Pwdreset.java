package com.pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class Pwdreset extends HttpServlet{
	Connection con;
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///databasename","root","mysql");
		} catch (Exception e) {
			System.out.println("Dataconnection faile..");
		}
	}
	String vemail = null;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	PrintWriter out =resp.getWriter();
	
	try {
		Statement stmt = con.createStatement();
		String sql = "select email from registration where email="+"'"+email+"'";
		ResultSet rs = stmt.executeQuery(sql);
		int count=0;
		while(rs.next()) {
			if(email.equals(rs.getString(1))) {
				vemail=rs.getString(1);
			}
		}
	}catch(Exception e) {
		resp.setContentType("text/html");
		resp.sendRedirect("ForgetpwdPage.html");
	}
	if(email.equals(vemail)) {
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
			        session1.setAttribute("email",email);
			        resp.sendRedirect("Pwdverification.html");
			        
			}catch(Exception e) {
				resp.setContentType("text/html");
				resp.sendRedirect("ForgetpwdPage.html");
			}
	}else {
		resp.setContentType("text/html");
		out.print("<p>Please Enter Submitted Email id</p>");
		RequestDispatcher dp = req.getRequestDispatcher("ForgetpwdPage.html");
		dp.include(req, resp);
	}
		
			
	
	
}

@Override
public void destroy() {
	try {
		con.close();
	} catch (SQLException e) {
		System.out.println("Connection not Close");
	}
}

public static String getRandom() {
	Random rnd = new Random();
	int num = rnd.nextInt(999999);
	return String.format("%06d", num);
}
}
