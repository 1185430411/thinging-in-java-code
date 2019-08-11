package com.jay.online;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class sessionListen
 *
 */
public class sessionListen implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public sessionListen() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         HttpSession currentSession=arg0.getSession();
         
         ServletContext s=currentSession.getServletContext();
         //本来ip地址只能从request中取得，但提前在session中加入了ip
         String ip=(String) currentSession.getAttribute("ipmap");
         
         Map<String,List<HttpSession>> map=(Map<String, List<HttpSession>>) s.getAttribute(ip);
         List<HttpSession> list=map.get(ip);
         
         //从session组中移除该session
         list.remove(currentSession);
         
         if(list.size()==0) {
        	 map.remove(ip);
         }else {
        	 map.put(ip, list);
         }
         
         s.setAttribute("ipmap", map);
    }
	
}
