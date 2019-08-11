package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*
 * javaweb创建监听器的步骤：
*  创建一个类，实现指定的监听器接口
*  重写接口中的方法
* 在web.xml文件中配置监听器
 * */
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
