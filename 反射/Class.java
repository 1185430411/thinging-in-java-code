/*
*每一个类都有一个class文件
*/

//person.java

package JAY01;

public class person{
	private String name;
	
	public person(String name) {
		this.name=name;
	}
	
}



//Test.java
package JAY01;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		Class c1=Class.forName("JAY01.person");
		
		Class c2=person.class;
		
		person p=new person("张三");
		Class c3=p.getClass();
		
		System.out.println(c1==c2);  //true
		System.out.println(c2==c3);  ///true
	}
}
