package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int k =Integer.parseInt(req.getParameter("k"));
		k=k+k;
		PrintWriter out = resp.getWriter();
		out.print(k);
		System.out.println("Sq called");
	}
}
