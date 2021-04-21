package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTwo extends HttpServlet{
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql:///databasename","root","mysql");
		} catch (Exception e) {
			System.out.println("Not Connected");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String pno = req.getParameter("pno");
		String dob = req.getParameter("dob");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String cpwd = req.getParameter("cpwd");
		PrintWriter out = resp.getWriter();
		if(cpwd.equals(pwd)) {
			try {
				String query = " insert into testdb (firstname, lastname, phonenumber, dob, email, password) values (?, ?, ?, ?, ?, ?)";
				 PreparedStatement pre = con.prepareStatement(query);
				 pre.setString(1, fname);
				  pre.setString(2, lname);
				  pre.setString(3, pno);
				  pre.setString(4, dob);
			      pre.setString(5, email);
			      pre.setString(6, pwd);
			      int n =pre.executeUpdate();
			      out.print(n+ " Data entered Successfully....");
			      
			}catch (Exception e) {
				out.print("Error");
			}
			
			 
		}else {
			out.print("Password and Conform Password must be same..");
		}
		
	}
	@Override
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
