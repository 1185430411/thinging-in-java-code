package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;





public class Test {
	public static void main(String[] args) {
		Thread t1=new Thread() {
			public void run() {
				try {
					Thread.sleep(1000000000000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<5;i++) {
					System.out.println("jay");
				}
			}
		};
		
		t1.start();
		t1.interrupt();
		
		//java.lang.InterruptedException: sleep interrupted
		//jay
		//jay
		//jay
		//jay
		//jay
			//at java.lang.Thread.sleep(Native Method)
			//at JAY01.Test$1.run(Test.java:18)
		
		
		//因为中断被唤醒了，所以抛出睡眠的异常是理所应当
	}
}
