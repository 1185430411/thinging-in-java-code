package com.jay.servlet;

import javax.servlet.*;
import java.io.IOException;

public class test implements Servlet {
    private ServletConfig config;

    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        ServletContext application = this.config.getServletContext();
        System.out.println("ContextTest01:" + application); //ContextTest01:org.apache.catalina.core.ApplicationContextFacade@1e38831b

        //获取web.xml中的配置信息
        String driver = application.getInitParameter("MySQLDriver");
        System.out.println(driver);

        String contextPath = application.getContextPath();
        System.out.println("contextPath:" + contextPath);

        //文件在硬盘中的绝对路径
        String realPath = application.getRealPath("FirstServlet");
        System.out.println("realPath:" + realPath);

        //向ServletContext中添加属性，其他的servlet可以通过getAttribute获取该值
        application.setAttribute("admin", "tiger");
        application.setAttribute("password", 123456);
        //删除password
        application.removeAttribute("password");
    }
}
