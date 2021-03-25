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

public class UpdateDb extends HttpServlet{
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		String pwd = req.getParameter("pwd");
		String c_pwd = req.getParameter("c_pwd");
		PrintWriter out = resp.getWriter();
		if(c_pwd.equals(pwd)) {
			try {
				String query ="update registration set password = ? where email = "+"'"+email+"'";
				PreparedStatement pre = con.prepareStatement(query);
				 pre.setString(1, pwd);
				 int n =pre.executeUpdate();
				  System.out.print(n+ " Data Updated Successfully..");
				  out.print("Data entered Successfully....");
				  resp.setContentType("text/html");
				  resp.sendRedirect("Login.html");
				  pre.close();
			}
			catch(Exception e) {
				  resp.setContentType("text/html");
				  out.print("<p>Data not Updated</p>");
				  
				  RequestDispatcher dp = req.getRequestDispatcher("Newpwd.html");
					dp.include(req, resp); 
			}
		}else {
			 resp.setContentType("text/html");
			  out.print("<p>Password and Confrom Password must be same</p>");
			  
			  RequestDispatcher dp = req.getRequestDispatcher("Newpwd.html");
				dp.include(req, resp); 
		}
		
	}
	@Override
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Not Close");
		}
	}
}
