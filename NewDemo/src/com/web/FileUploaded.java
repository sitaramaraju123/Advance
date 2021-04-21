package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

public class FileUploaded extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");  
		          
		MultipartRequest m=new MultipartRequest(req,"d:/file");
		PrintWriter out = resp.getWriter();  
		out.print("successfully uploaded");  
		
		resp.setContentType("text/html");
		out.print("<br>");
		String file = m.getOriginalFileName("file");
		HttpSession se = req.getSession();
		se.setAttribute("file", file);
		out.print("<a href='viewfile'><button>view</button></a>");
		
		out.print("<a href='download'><button>Download</button></a>");
	}
}
