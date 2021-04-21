package com.demo;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class RegisterDb extends GenericServlet{
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///databasename","root","mysql");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("uname");
		String email=req.getParameter("Email");
		String phone = req.getParameter("phone");
		String dob = req.getParameter("dob");
		String pwd = req.getParameter("pwd");
		String cpwd=req.getParameter("conpwd");
		PrintWriter out = res.getWriter();
		try {
			String query = " insert into registration (name, email, phone, Date_of_birth, password) values (?, ?, ?, ?, ?)";
			  PreparedStatement pre = con.prepareStatement(query);
			  pre.setString(1, name);
			  pre.setString(2, email);
			  pre.setString(3, phone);
			  pre.setString(4, dob);
			  if(pwd.equals(cpwd)) {
				  pre.setString(5, pwd);
			  }else {
				  out.print("Re-Enter your Password...");
			  }
			  int n =pre.executeUpdate();
			  System.out.print(n+ " Rows of Data Inserted Successfully..");
			  out.print("Data entered Successfully....");
			  res.setContentType("text/html");  
				out.print("<a href=http://localhost:8080/DemoWebSite/download>Login</a>");  
			  pre.close();
			 
		}catch (Exception e) {
			out.print("Error occured....");
		}
		
	}
	@Override
	public void destroy() {
		 try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
