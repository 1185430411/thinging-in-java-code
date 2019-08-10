package com.jay.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dodo
 */
public class dodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dodo() {
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
		out.write("全部书籍<br>");
		
		Map<String,book> book=chushihua.findallbook();
		for(Map.Entry<String, book> singlebook:book.entrySet()) {
			
			//设置点击后的触发地址。可以设置在点击时就把id设为书的id，以便add类的获取id
			String address=request.getContextPath()+"/add?id="+singlebook.getKey();
			out.write("<a href='"+address+"'>"+singlebook.getValue().getName()+"</a><br>");
		}
		String address2=request.getContextPath()+"/show";
		out.write("<a href='"+address2+"'>查看购物车"+"</a>");
		
		String address3=request.getContextPath()+"/clean";
		out.write("<a href='"+address3+"'>清空购物车"+"</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
