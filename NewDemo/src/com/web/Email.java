package com.web;

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
import javax.servlet.ServletResponse;

public class Email{
	public String getRandom() {
		Random rnd = new Random();
		int num = rnd.nextInt(9999);
		return String.format("%04d", num);
	}
	
	public boolean Email(User user, ServletResponse res) throws IOException {
		boolean test=false;
		
		String toemail = user.getEmail();
		String fromemail="sitaramaraju123463@gmail.com";
		String pwd = "ramaraju2143";
		
		try {
			 Properties props = new Properties();    
	          props.put("mail.smtp.host", "smtp.gmail.com");    
	          props.put("mail.smtp.socketFactory.port", "465");    
	          props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
	          props.put("mail.smtp.auth", "true");    
	        //  props.put("mail.smtp.port", "465");     
	          Session session = Session.getDefaultInstance(props,new Authenticator() {    
	                  protected PasswordAuthentication getPasswordAuthentication() {    
	                  return new PasswordAuthentication(fromemail,pwd);  
	                  }    
	                 });
	          
	          MimeMessage  msg = new  MimeMessage(session);
	          msg.setFrom(new InternetAddress(fromemail));
	          msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
	          msg.setSubject("User Email Verification");
	          msg.setText("Verify your Account using this Code: "+user.getCode());
	          Transport.send(msg);
	          test = true;
		}catch(Exception e) {
			PrintWriter out = res.getWriter();
			out.print("Email");
		}
		return test;
	}
}
