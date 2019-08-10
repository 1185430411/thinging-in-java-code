package com.jay.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		
		String name="";
		String password="";
		Cookie[] c=request.getCookies();
		//在弹出登陆界面之前，需要进行判断，若已经存在了对应的Cookie，则无需再进入登陆界面
		for(int i=0;c!=null&&i<c.length;i++) {
			if("password".equals(c[i].getName())) password=c[i].getValue();
			if("username".equals(c[i].getName())) name=c[i].getValue();
		}
		
		if(name.equals("admin")&&password.equals("123")) {
			out.write("登陆成功");
		}else{
			out.write("<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\">\r\n" + 
					"<title>登陆</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<form action='dologin' method=\"post\">\r\n" + 
					"		用户名:<input name='username' type='text'> <br> 密码:<input\r\n" + 
					"			name='password' type='password'> <br> <input\r\n" + 
					"			name='remember' type='checkbox'>十天免登录 <br> <input\r\n" + 
					"			type='submit' value='登陆'>\r\n" + 
					"	</form>\r\n" + 
					"</body>\r\n" + 
					"</html>");
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
