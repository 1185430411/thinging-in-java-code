package JAY01;

/*
 * 运用Runnable接口实现多线程方法：
 * 1.自定义类，继承Runnable接口
 * 2.重写run方法。在run方法中编写线程要执行的内容
 * 3.在主线程中创建自定义类对象
 * 4.创建Thread对象，将自定义类对象作为参数传入构造方法中
 * 5.对Thread对象使用start函数
 */

/*
 * 其实Thread类也连接了Runnable接口
 * */

class myThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<200;i++) {
			System.out.println("jay");
		}
	}
	
}

public class Test {
	public static void main(String[] args) {
		myThread mt=new myThread();
		Thread t=new Thread(mt);
		t.start();
		
		for(int i=0;i<200;i++) {
			System.out.println("main");
		}
		
		 //结果依然是main和jay交替或连续打印。 
	}
}
