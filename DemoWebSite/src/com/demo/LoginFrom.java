package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFrom extends GenericServlet{
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///databasename","root","mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		PrintWriter out =res.getWriter();
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT name, password FROM registration";
			ResultSet rs    = stmt.executeQuery(sql);
			int count=0;
			while(rs.next()) {
				if(uname.equalsIgnoreCase(rs.getString(1)) && pwd.equalsIgnoreCase(rs.getString(2))) {
					count++;
					res.setContentType("text/html");  
					RequestDispatcher dp = req.getRequestDispatcher("Home.html");
					dp.forward(req, res);
					break;
				}
			}
			if(count==0) {
				res.setContentType("text/html");
				out.print("Wrong details please try again..");
				RequestDispatcher dp = req.getRequestDispatcher("Login.html");
				dp.include(req, res);
				
			}
			rs.close();
			stmt.close();
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
