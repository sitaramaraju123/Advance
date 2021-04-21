package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DemoSession extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String sessionId = session.getId();
		out.print("sessionId "+sessionId);
		session.setAttribute("x",10);
		Cookie  rememberMeCookie = new Cookie("myCookie","Ram");
		rememberMeCookie.setMaxAge(143);
		resp.addCookie(rememberMeCookie);
		Cookie[] cookies =req.getCookies();
		for(Cookie cookie : cookies) {
			out.print("Cookie "+cookie.getName()+" :: "+cookie.getValue());
		}
	}
}
