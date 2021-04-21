package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletOne extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String pno = req.getParameter("num");
		PrintWriter out = resp.getWriter();
		out.print("Once Check out your details: "+fname+"  "+lname+"  "+pno+" \n ");
		
		resp.setContentType("text/html");
		out.print("<form action='./SerTwo' method='post'>");  
        out.print("<input type='hidden' name='fname' value='"+fname+"'>");
        out.print("<input type='hidden' name='lname' value='"+lname+"'>");
        out.print("<input type='hidden' name='pno' value='"+pno+"'>");
        out.print("<input type='date' name='dob' placeholder='DoB'>");
        out.print("<input type='text' name='email' placeholder='Email'>");
        out.print("<input type='password' name='pwd' placeholder='Password'>");
        out.print("<input type='password' name='cpwd' placeholder='Conform Password'>");
        out.print("<input type='submit' value='Submit'>");  
        out.print("<a href='http://localhost:8080/NewDemo/ReqOne.html'>Back</a>");
        out.print("</form>");  
        out.close();
	}
}
