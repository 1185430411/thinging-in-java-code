package JAY01;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		Class c=Class.forName("JAY01.person");
		Field f=c.getDeclaredField("name");
		Object o=c.newInstance();
		f.set(o, "张三");
		System.out.println(f.get(o));   //张三
		
		Field f2=c.getDeclaredField("age");
		Object o2=c.newInstance();
		f2.setAccessible(true);//因为age是private的。要把其访问权限设为true.其实这样做不太
		f2.set(o2, 20);
		System.out.println(f2.get(o2)); //20
	}
}
