package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoDispatch extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.print("hai i am Include");
		RequestDispatcher rs = req.getRequestDispatcher("/");
		rs.include(req, resp);  //include method
		
//		rs.forward(req, resp);  // forward method
		resp.setContentType("text/html");
		  resp.setContentType("text/html");  
			out.print("<a href=#>Login</a>");  
	}
	
}
