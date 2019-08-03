package JAY01;

/*
 * 单例模式
 * 确保一个对象只有一个类。
 * 确保线程安全
 * */

//饿汉式
class test1{
	//构造方法私有化，外部不能通过构造方法来构造对象
	private test1(){	
	}
	//加上static为了使对象只被创建一次
	private static test1 t=new test1();
	
	//外部只能通过方法构造一次对象
	public static test1 getTest() {
		return t;
	}
	
}


//懒汉式
class test2{
	//构造方法私有化
	private test2() {		
	}
	
	//让对象加上volatile关键字。
	private volatile static test2 t=null;
	
	//get方法加上synchronized关键字
	public static synchronized test2 getTest2() {
		if(t==null) t=new test2();
		return t;
	}
	
}
public class Test {
	public static void main(String[] args) {
		test1 t1=test1.getTest();
		test1 t2=test1.getTest();	
		System.out.println(t1==t2);   //true
		
		test2 t3=test2.getTest2();
		test2 t4=test2.getTest2();
		System.out.println(t3==t4);    //true
	}
}

