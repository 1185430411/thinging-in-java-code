package JAY01;

import java.util.Date;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c2=Class.forName("java.util.Date");
		Object o=c2.newInstance();
		
		if(o instanceof Date) {
			System.out.println(o);  //Sun Aug 04 14:38:26 CST 2019

		}
		
	}
}
