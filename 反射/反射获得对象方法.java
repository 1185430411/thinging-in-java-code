package JAY01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		Class c=Class.forName("JAY01.person");
		Method[] m1=c.getDeclaredMethods();
		for(Method m:m1) {
			System.out.println(Modifier.toString(m.getModifiers()));   //获得方法修饰符
			
			System.out.println(m.getReturnType());    //获得返回值类型
			
			System.out.println(m.getName());    //获得方法名
			
			Class[] param=m.getParameterTypes();   //获得参数组
			for(Class c1:param) {   //遍历参数组
				System.out.println(c1.getName());
			}
		}
		
		/*public static
		void
		w1
		public
		double
		m3
		int
		public
		int
		m2
		*/

	}
}
