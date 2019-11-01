package com.jay.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class cookie1 extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie cookie1 = new Cookie("username","monkey1024");
        cookie1.setMaxAge(60*60);  //单位为秒   设置为一小时
        Cookie cookie2 = new Cookie("password","123456");
        cookie1.setMaxAge(60*60*24);  //设置为一天

        //手动设置绑定路径,将cookie放置到以下url下
        cookie1.setPath(request.getContextPath() + "/getcookie");
        cookie2.setPath(request.getContextPath() + "/getcookie");

        //将Cookie添加到相应中
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
