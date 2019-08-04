package JAY01;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		Class c1=Class.forName("JAY01.person");
		Field[] f=c1.getFields();  //获得public的元素，以Field形式返回
		for(Field fi:f) {
			System.out.println(fi.getName());  //age
		}
		
		Field[] f2=c1.getDeclaredFields();
		for(Field fi:f2) {
			System.out.print(fi.getName());  //nameagebirthdaytall
		}
	}
}
