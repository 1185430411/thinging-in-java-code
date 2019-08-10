package com.jay.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dologin
 */
public class dologin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dologin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		//获取输入信息
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String remember=request.getParameter("remember");
		//若输入信息与账户密码匹配
		if("admin".equals(name)&&"123".equals(password)) {
			out.write("登陆成功");
			//若勾选了十天免登陆，则把账户密码装进Cookie
			if(remember!=null){
				Cookie c1=new Cookie("username",name);
				Cookie c2=new Cookie("password",password);
				c1.setMaxAge(60*60*24*10);
				c2.setMaxAge(60*60*24*10);
				
				response.addCookie(c1);
				response.addCookie(c2);
			}
		}else {
			//两秒后跳转到该界面
			response.setHeader("refresh", "2;localhost:8080/cookie1/login/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
