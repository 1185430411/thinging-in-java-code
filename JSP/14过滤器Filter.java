package com.jay.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/*连接Filter接口。生命周期与Servlet类似：实例化，初始化，doFilter，销毁*/
public class test01 implements Filter {
	
	public test01() {
		System.out.println("实例化");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤请求");
		
		//通过过滤器访问资源
		arg2.doFilter(arg0, arg1);
		System.out.println("过滤效应");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化");
	}

}
