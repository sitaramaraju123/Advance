package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SerTwo extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  try{  
		  
	        resp.setContentType("text/html");  
	        PrintWriter out = resp.getWriter();  
	          
	        //getting value from the query string  
	        String n=req.getParameter("fname");
	        String n1=req.getParameter("lname");
	        String email=req.getParameter("email");
	        String pwd = req.getParameter("pwd");
	        out.print(n+" , "+n1+" , "+email+" , "+pwd);  
	  
	        out.close();  
	  
	                }catch(Exception e){System.out.println(e);}  
}
}
