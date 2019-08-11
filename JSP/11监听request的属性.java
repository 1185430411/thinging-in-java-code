package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Application Lifecycle Listener implementation class lis
 *
 */
public class lis implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public lis() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
         System.out.println("从request删除了一个属性");
         System.out.println(arg0.getName());
         System.out.println(arg0.getValue());
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	 System.out.println("从request添加了一个属性");
         System.out.println(arg0.getName());
         System.out.println(arg0.getValue());
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	 System.out.println("从request修改了一个属性");
         System.out.println(arg0.getName());
         System.out.println(arg0.getValue());
    }
	
}
