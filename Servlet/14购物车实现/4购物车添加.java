package com.jay.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class add
 */
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
		
		//取得图书id
		String id=request.getParameter("id");
		
		//session
		HttpSession s=request.getSession();
		Map<String,Integer> map=(Map<String,Integer>)s.getAttribute("shoppingcart");
		if(map==null) {
			//说明session是空
			map=new HashMap<String,Integer>();
		}
		
		if(map.get(id)==null) {
			//若这个购物车还没这个图书
			map.put(id, 1);
		}else {
			map.put(id, map.get(id)+1);//在以前的基础上加一本	
		}
		
		s.setAttribute("shoppingcart", map);
		out.write("购物车添加成功");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
