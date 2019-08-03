package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;




public class Test {
	private static Object object1=new Object();
	private static Object object2=new Object();
	public static void main(String[] args) {
		/*
		 * 死锁:互相等待对方资源的释放，陷入了永久性的中断
		 * */
		Thread t1=new Thread() {
			public void run() {
				synchronized(object1) {
					System.out.println("111");
					synchronized(object2) {
						System.out.println("222");
					}
				}
			}
		};
		
		
		Thread t2=new Thread() {
			public void run() {
				synchronized(object2) {
					System.out.println("333");
					synchronized(object1) {
						System.out.println("444");
					}
				}
			}
		};
		
		t1.start();
		t2.start();
		
		//333
		//111
		
		


	}
}

