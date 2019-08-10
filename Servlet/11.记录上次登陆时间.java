package com.jay.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class visit
 */
//记录上次登陆时间
public class visit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public visit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		response.setContentType("text/html;charset=UTF-8");
		//输出流，用来在网页上显示
		PrintWriter out=response.getWriter();
		
		
		//获取cookies数组
		Cookie[]cookies=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++) {
			//若找到了记录时间的cookie
			if("lastVisitTime".equals(cookies[i].getName())) {
				//转为long型
				long time=Long.parseLong(cookies[i].getValue());
				out.write("您的上次登陆时间是："+new Date(time).toLocaleString());
			}
		}
		
		//每次访问都重置覆盖掉访问时间
		Cookie c=new Cookie("lastVisitTime",System.currentTimeMillis()+""); //获取当前时间
		c.setMaxAge(60*60);  //设置存活时间
		//加入
		response.addCookie(c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
