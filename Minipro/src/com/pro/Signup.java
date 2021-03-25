package com.pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Signup extends HttpServlet{
	Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql:///databasename","root","mysql");
		} catch (Exception e) {
			System.out.println("Not Connected");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String code = (String) session.getAttribute("authcode");
		String name = (String) session.getAttribute("name");
		String email = (String) session.getAttribute("email");
		String phone = (String) session.getAttribute("phone");
		String dob = (String) session.getAttribute("dob");
		String pwd = (String) session.getAttribute("pwd");
		String vrcode = req.getParameter("code");
		
		PrintWriter out = res.getWriter();
		if(vrcode.equals(code)) {
			try {
				String query = " insert into registration (name, email, phone, Date_of_birth, password) values (?, ?, ?, ?, ?)";
				  PreparedStatement pre = con.prepareStatement(query);
				  pre.setString(1, name);
				  pre.setString(2, email);
				  pre.setString(3, phone);
				  pre.setString(4, dob);
			      pre.setString(5, pwd);
				  int n =pre.executeUpdate();
				  System.out.print(n+ " Rows of Data Inserted Successfully..");
				  out.print("Data entered Successfully....");
				  res.setContentType("text/html");
				  res.sendRedirect("Login.html");
				  pre.close();
				  
				}catch(Exception e){
					 res.setContentType("text/html");
					  out.print("Error Occured....");
					  res.sendRedirect("Register.html");
				}
		}else {
			 res.setContentType("text/html");
				out.print("<p>Entered Verification code is Wrong please Check And try Again..</p>");
				RequestDispatcher dp = req.getRequestDispatcher("Verifycode.html");
				dp.include(req, res); 
		}
	}
	@Override
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("not closed");
		}
	}
}
