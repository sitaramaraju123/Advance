package com.pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdatingPwd extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	String email = (String) session.getAttribute("email");
	String code = (String) session.getAttribute("authcode");
	String vrcode = req.getParameter("code");
	
	PrintWriter out = resp.getWriter();
	if(vrcode.equals(code)) {
		resp.setContentType("text/html");
		  resp.sendRedirect("Newpwd.html");
	}else {
		 resp.setContentType("text/html");
			out.print("<p>Entered Verification code is Wrong please Check And try Again..</p>");
			RequestDispatcher dp = req.getRequestDispatcher("Pwdverification.html");
			dp.include(req, resp); 
	}
}
}
