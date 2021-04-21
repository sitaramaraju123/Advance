package com.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ImageDemo extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	   res.setContentType("image/jpeg");  
	   ServletOutputStream out;  
		out = res.getOutputStream();  
		FileInputStream fin = new FileInputStream("D:\\hari.jpg");
		BufferedInputStream bin= new BufferedInputStream(fin);
		BufferedOutputStream bout= new BufferedOutputStream(out);
		int ch = 0;
		while((ch = bin.read())!=-1) {
			bout.write(ch);
		}
		out.close();
		fin.close();
		bin.close();
		bout.close();
	}

}
