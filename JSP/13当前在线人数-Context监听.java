package com.jay.online;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

/**
 * Application Lifecycle Listener implementation class listenContext
 *
 */

/*
 * 每个网页打开就是一个session。
 * 一个ip地址对应一个用户在登陆,也对应了一个request
 * 一个ip地址可能有多个session（比如打开了多个网页）
 * 始终只有一个ServletContext
 * 而
 * 所以在Servlet中存放一个Map<ip地址，同一个ip地址对应Session数组>
 * */
public class listenContext implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext sc=arg0.getServletContext();
    	Map<String,List<HttpSession>> ipmap=new HashMap<String,List<HttpSession>>();
    	sc.setAttribute("ipmap", ipmap);
    }
	
}
