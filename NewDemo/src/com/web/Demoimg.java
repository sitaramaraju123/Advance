package com.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demoimg extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession se = req.getSession();
		String img = (String) se.getAttribute("img");
		resp.setContentType("image/jpeg"); 
		ServletOutputStream out = resp.getOutputStream();
		FileInputStream fin = new FileInputStream("D:\\new\\"+img);
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch=0;
		while((ch=bin.read())!=-1) {
			bout.write(ch);
		}
		out.close();
		fin.close();
		bin.close();
		bout.close();
		
		
	}
	
	

}
