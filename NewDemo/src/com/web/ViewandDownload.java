package com.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

public class ViewandDownload extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MultipartRequest m=new MultipartRequest(req,"d:/new");
		PrintWriter out = resp.getWriter();  
		out.print("successfully uploaded");  
		
		resp.setContentType("text/html");
		out.print("<br>");
		String image = m.getOriginalFileName("img");
		HttpSession se = req.getSession();
		se.setAttribute("img", image);
		out.print("<a href='img/*'><button>view</button></a>");
		
		out.print("<a href='download'><button>Download</button></a>");
	
	
		  
	}
}
