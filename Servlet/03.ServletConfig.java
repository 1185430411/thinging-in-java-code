	package com.jay.servlet;
	
	import java.io.IOException;
	import java.util.Enumeration;
	
	import javax.servlet.Servlet;
	import javax.servlet.ServletConfig;
	import javax.servlet.ServletException;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;
	
	public class Config implements Servlet {
		ServletConfig config;
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
			this.config=config;   //爲了保留config
		}
	
		@Override
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//獲取web.xml中的單個配置參數
			String name=config.getInitParameter("userName");
			System.out.println(name);
			//獲取web.xml中所有配置參數
			Enumeration<String> e=config.getInitParameterNames();  //返回枚舉
			while(e.hasMoreElements()) {
				String key=e.nextElement();  //獲取<param-name>
				String res1=config.getInitParameter(key);  //根據param-name獲取param-value
				System.out.println(res1);
			}
			
			System.out.println("ServletName:"+config.getServletName());	
		}
	
	}
