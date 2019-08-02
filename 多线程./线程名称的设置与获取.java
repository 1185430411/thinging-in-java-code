package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;





public class Test {
	public static void main(String[] args) {
		method1();  //我是马化腾
		            //我是马云
		
		method2(); //我是马化腾
		           //我是马云
		
		new Thread() {
			public void run() {
				this.setName("阿里巴巴");
				System.out.println(Thread.currentThread().getName());  //Thread.currentThread()获取当前线程的对象
			}
		}.start();   //阿里巴巴
		
		
	}
	
	
	public static void method1() {
		new Thread() {
			public void run() {
				this.setName("马化腾");
				System.out.println("我是"+this.getName());
			}
		}.start();
		
		
		new Thread() {
			public void run() {
				this.setName("马云");
				System.out.println("我是"+this.getName());
			}
		}.start();

	}
	
	public static void method2() {
		new Thread("马化腾") {
			public void run() {
				System.out.println("我是"+this.getName());
			}
		}.start();
		
		new Thread("马云") {
			public void run() {
				System.out.println("我是"+this.getName());
			}
		}.start();
	}
}
