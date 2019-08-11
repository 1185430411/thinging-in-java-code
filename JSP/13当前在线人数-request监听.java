package com.jay.online;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Application Lifecycle Listener implementation class requestListen
 *
 */
public class requestListen implements ServletRequestListener {

   
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
        //获取当前ip的request 
    	HttpServletRequest sr=(HttpServletRequest) arg0.getServletRequest();
         //获取ip地址
         String ip=sr.getRemoteAddr();
         ServletContext sc=arg0.getServletContext();
         //获取对应的图
         Map<String,List<HttpSession>> map=(Map<String, List<HttpSession>>) sc.getAttribute("ipmap");
         //获取该ip对应的list
         List<HttpSession> list=map.get(ip);	
         
         //若list空，则该ip当前没有一个在线的session
         if(list==null) {
        	 list=new ArrayList<HttpSession>();
         }
         
         //获得当前的Session
         HttpSession currentSession = sr.getSession();
         for(HttpSession s:list) {
        	 if(s==currentSession) return;  //若该session已经在List里面，则方法结束
         }
         
         //当上面条件都不满足时
         list.add(currentSession);
         map.put(ip, list);
         sr.setAttribute("ipmap", map);
         
         //为了删除session方便，将ip加在session中
         currentSession.setAttribute("ip", ip);
    }
	
}
