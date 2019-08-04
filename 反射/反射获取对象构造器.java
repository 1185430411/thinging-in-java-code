package JAY01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Test{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c=Class.forName("JAY01.person");  //创建Class文件
		Constructor[] con=c.getDeclaredConstructors();
		for(Constructor c1:con) {
			System.out.println(Modifier.toString(c1.getModifiers()));  //获得修饰符
			
			System.out.println(c1.getName());   //获得方法名
			
			Class[] cla=c1.getParameterTypes();  //获得参数
			for(Class cla1:cla) {
				System.out.println(cla1.getName());
			}
		}
		
		//public
		//JAY01.person
		//int


	}
}
