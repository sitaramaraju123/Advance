package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SerOne extends HttpServlet{
	  String fname="";
	  String lname="";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{  
			  
	        resp.setContentType("text/html");  
	        PrintWriter out = resp.getWriter();  

	        String n=req.getParameter("fname");  
	        String n1 = req.getParameter("lname");
	        String email=req.getParameter("email");
	        String pwd = req.getParameter("pwd");
	        HttpSession session=req.getSession(); 
	        if(n!=null && n1!=null) {
	        	session.setAttribute("n", n);
		        session.setAttribute("n1", n1);
		        fname = (String) session.getAttribute("n");
	           	lname =(String) session.getAttribute("n1");
	           	out.print(fname);
	        }
	        
	        session.setAttribute("email",email);
	        if(session.getAttribute("email") == null) {
	        	out.print("<form action=\"./srvone\" method=\"post\">");
	        	out.print("<input type='text' name='email' placeholder='Email'/>");
	        	out.print("<input type='password' name='pwd' placeholder='Password'/>");
	        	out.print("<input type='submit' value='Next'/>");
	        	out.print("</form>");
	        }else {
	        	out.println("First Name: "+fname);
	        	out.println("Last Name: "+lname);
	        	out.println("Email: "+email);
	        	out.print("Password: "+pwd);
	        	out.print("<a href='srvtwo?fname="+fname+"&lname="+lname+"&email="+email+"&pwd="+pwd+"'>Submit</a>");
	        }
	        
	        out.close();  
	  
	                }catch(Exception e){System.out.println(e);}  
	}
}
