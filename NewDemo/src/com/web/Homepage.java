package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Homepage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		ServletConfig config = getServletConfig();
		String info = req.getParameter("info");             //request parameters
		String pwd = config.getInitParameter("password");  //init parameter
		
		ServletContext cxt = getServletContext();
		String name = cxt .getInitParameter("test");
		out.print("Welcome to Home Page "+pwd+" "+info+ " "+name);
		
		
		
		ServletOutputStream output = resp.getOutputStream();
	}
}
