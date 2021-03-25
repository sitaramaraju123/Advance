package com.pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet{
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
	String uname = req.getParameter("uname");
	String pwd = req.getParameter("pwd");
	PrintWriter out =res.getWriter();
	try {
		Statement stmt = con.createStatement();
		String sql = "select name, password from registration where name="+"'"+uname+"'";
		ResultSet rs = stmt.executeQuery(sql);
		int count=0;
		while(rs.next()) {
			if(uname.equals(rs.getString(1)) && pwd.equals(rs.getString(2))) {
				count++;
				 HttpSession session=req.getSession();  
			        session.setAttribute("name",uname);  
				res.sendRedirect("homepage");
			}
		}
		if(count==0) {
			res.setContentType("text/html");
			out.print("<p>Wrong details please try again..</p>");
			RequestDispatcher dp = req.getRequestDispatcher("Login.html");
			dp.include(req, res);
		}
		rs.close();
		stmt.close();
		
	}catch (Exception e) {
		res.setContentType("text/html");
		out.print("<p>Error Occur..</P>");
		RequestDispatcher dp = req.getRequestDispatcher("Login.html");
		dp.include(req, res);
	}
	}
@Override
public void destroy() {
	try {
		con.close();
	} catch (SQLException e) {
		System.out.println("Not close");
	}
}
}
