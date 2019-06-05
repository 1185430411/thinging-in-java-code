package test;

public class privateex {

	private privateex() {
		// TODO Auto-generated constructor stub
	}
	
	
	protected  static privateex make() {
		System.out.println(8);
		return new privateex();
	}

}


package thinkinginjava;
import test.privateex;

public class testprivate extends privateex{
	public static void main(String[] args) {
		//privateex a=new privateex();
		privateex b=privateex.make();       //因为构造器是private的，只能通过privateex的方法来构建对象。而protected的方法可以被其继承的类使用
	}
}


/*
测试结果：
8
*/
