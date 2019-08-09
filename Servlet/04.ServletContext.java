package com.jay.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletContext implements Servlet {
	private ServletConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

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
		this.config=config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		javax.servlet.ServletContext app=this.config.getServletContext();
		String name1=app.getInitParameter("name");
		System.out.println(name1);
		
		Enumeration<String> e=app.getInitParameterNames();
		while(e.hasMoreElements()) {
			String key=e.nextElement();
			String value=app.getInitParameter(key);
			System.out.println(value);
		}
		
		app.setAttribute("bir", 20000607); //相当于map的put
		
	}

}
