package com.demo;

import java.io.Serializable;

public class LoginBean implements Serializable{
	public LoginBean() {}
	private String uname ="uname";
	private String pwd = "pwd";
	public String getUname() {
		System.out.println("Getter Called");
		return uname;
	}
	public void setUname(String uname) {
		System.out.println("Setter Called");
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
		
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
