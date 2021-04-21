package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Verifycode extends HttpServlet{ 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try(PrintWriter out = resp.getWriter()){
			HttpSession session = req.getSession();
			User user=(User) session.getAttribute("authcode");
			String code=req.getParameter("authcode");
			if(code.equals(user.getCode())) {
				out.print("Verification Done");
			}else {
				out.print("Incorrect verification code");
			}
		}
		
	}
}
