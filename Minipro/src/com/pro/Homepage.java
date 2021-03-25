package com.pro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Homepage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		 HttpSession session=req.getSession(false);  
	        if(session!=null){  
	        String name=(String)session.getAttribute("name");  
	          
	        out.print("Welcome "+name); 
	        resp.setContentType("text/html");  
	        out.print("<a href=logout><button type='button'>Logout</button></a>");  
	        }  
	        else{  
	            out.print("Please login first");  
	            resp.sendRedirect("Login.html");
	        }  
	        out.close();  
	}
}
