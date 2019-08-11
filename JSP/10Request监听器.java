package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*
 * javaweb创建监听器的步骤：
*  创建一个类，实现指定的监听器接口
*  重写接口中的方法
* 在web.xml文件中配置监听器
 * */

/*
监听web对象创建与销毁的监听器
ServletContextListener
HttpSessionListener
ServletRequestListener
监听web对象属性变化的监听器
ServletContextAttributeListener
HttpSessionAttributeListener
ServletRequestAttributeListener
监听session绑定javaBean操作的监听器
HttpSessionBindingListener
HttpSessionActivationListener
*/
public class test01 implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		 System.out.println("request对象被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		 System.out.println("request对象被創建");
	}

}
