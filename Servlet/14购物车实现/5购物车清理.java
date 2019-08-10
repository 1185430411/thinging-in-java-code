package com.jay.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class show
 */
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
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
		out.write("您的购物车中有以下商品:<br>");
		HttpSession s=request.getSession();
		Map<String,Integer> books=(Map<String, Integer>) s.getAttribute("shoppingcart");
		if(books==null) {
			out.write("您的购物车为空<br>");
			response.setHeader("reflesh", "2;url=localhost:8080/cookie1/dodo/");
			return;
		}
		
		for(Map.Entry<String, Integer> book:books.entrySet()) {
			book b=chushihua.findbookbyid(book.getKey());
			out.write("名称:"+b.getName()+" 数量："+book.getValue());
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
