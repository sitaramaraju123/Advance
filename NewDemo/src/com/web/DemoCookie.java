package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoCookie extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String phone = req.getParameter("phone");
		Cookie cookie = new Cookie("uname", uname);
		cookie.setMaxAge(55000);
		resp.addCookie(cookie);
		Cookie ck= new Cookie("phone", phone);
		resp.addCookie(ck);
		PrintWriter out = resp.getWriter();
		 resp.setContentType("text/html");  
		    out.print("<form action='./cookietwo' method='post'>");  
		    out.print("<input type='text' name='email' placeholder='Email' required='required'>");  
		    out.print("<input type='password' name='pwd' placeholder='Password' required='required'>");  
		    out.print("<input type='submit' value='Submit'>");  
		    out.print("</form>");  
		    out.close();  
	}
}
