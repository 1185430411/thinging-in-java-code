package com.jay.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletLife implements Servlet {
	
	/*
	 * 調用順序為：構造器(實例化)，init(初始化)，service。并且service方法可以被多次執行，而構造器與init
	 * 只被調用一次
	 * */
	
	public ServletLife() {
		System.out.println("調用無參構造器");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("調用destroy方法");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("調用init方法");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("調用service方法");
	}

}
