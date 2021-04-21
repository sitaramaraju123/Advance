package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemockTwo extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cookie ck[] = req.getCookies();
	String uname=null;
	String phone=null;
	for(int i=0;i<ck.length;i++) {
		uname=ck[0].getValue();
		phone = ck[1].getValue();
	}
	String email=req.getParameter("email");
	String pwd = req.getParameter("pwd");
	PrintWriter out = resp.getWriter();
	out.print(uname+"  "+phone+"  "+email+"  "+pwd);
}
}
