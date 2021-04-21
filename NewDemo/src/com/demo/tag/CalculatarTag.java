package com.demo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class CalculatarTag extends TagSupport{
	private int num1;
	private int num2;
	private char ch;

	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	
//	public void ch(char ch) {
//		this.ch = ch;
//	}
//	public void num1(int num1) {
//		this.num1 = num1;
//	}
//	
//	public void num2(int num2) {
//		this.num2 = num2;
//	}
	
	public int doStartTag() throws JspException{
		JspWriter out = pageContext.getOut();
		try {
		switch(ch) {
		case '+': out.print(num1+num2);
				  break;
		case '-': out.print(num1-num2);
		          break;
		case '*': out.print(num1*num2);
		          break;
		case '/': out.print(num1/num2);
		          break;
		}
		} catch (IOException e) {
			System.out.println(e);
		}
		return SKIP_BODY; 
	}
	
//	public int doEndTag() throws JspException{
//		JspWriter out = pageContext.getOut();
//		try {
//			//out.print(Result);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return EVAL_BODY_INCLUDE;
//		
//	}
}
