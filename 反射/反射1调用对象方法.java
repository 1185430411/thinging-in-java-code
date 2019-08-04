package JAY01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class c=Class.forName("JAY01.person");  //创建Class文件
		Method method=c.getDeclaredMethod("m3", double.class);  //获取方法。传入方法名和可变参数的class文件
		Object o=c.newInstance();  //创建新对象
		Object res=method.invoke(o, 5);  //通过Method类来启动方法
		System.out.println(res);  //5.0
	}
}
