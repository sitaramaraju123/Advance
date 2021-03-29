package com.pro;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportGn extends HttpServlet{
	 String db="";
	 String table="";
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///databasename","root","mysql");
			
			String name = req.getParameter("report");
			String q = "SELECT * FROM "+name;
			PreparedStatement stmt = con.prepareStatement(q);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			 PrintWriter out = resp.getWriter();
			 int n = rsMetaData.getColumnCount();
			 for(int j=1; j<=n;j++) {
					table += (rsMetaData.getColumnName(j)+"                   \t");
			 }
			 table = (table+"\r\n");
			 out.print(table);
			 while(rs.next()) {
				
			 for(int i=1; i<=n; i++) {
				
				db += (rs.getString(i)+"          \t");
			 }
			 db = (db+"\r\n"); 
			 }
			 out.print(db);
			
		con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 FileOutputStream fout = new FileOutputStream("D://Db.txt");
		 BufferedOutputStream bout =new BufferedOutputStream(fout);
		 char ch[] = db.toCharArray();
		 char ch1[]= table.toCharArray();
		 for(int j = 0; j<ch1.length; j++) {
			 bout.write(ch1[j]);
		 }
		for(int i=0; i<ch.length; i++) {
			 bout.write(ch[i]);
		 }
		 bout.close();
}
}
