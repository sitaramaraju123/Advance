package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.mail.iap.Response;

public class UserVerify extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out =  resp.getWriter();
		String name = req.getParameter("uname");
		String email= req.getParameter("email");
	
		Email sm = new Email();
		String code = sm.getRandom();
		User user = new User(name,email,code);
		boolean test = sm.Email(user,resp);
		if(test) {
			 HttpSession session=req.getSession();  
		        session.setAttribute("authcode",user);
		        resp.sendRedirect("Verify.html");
		}
	}
}

