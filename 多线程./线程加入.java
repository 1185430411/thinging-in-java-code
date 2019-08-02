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
				for(int i=0;i<50;i++) {
					System.out.println("jay");
				}
			}
		};
		
		Thread t2=new Thread() {
			public void run() {
				for(int i=0;i<50;i++) {
					if(i==10) {
						try {
							t1.join();  //当i运行到10时，t1加入，先执行t1，等到t1运行完了，再运行t2.宏观上，两者变成了一个线程
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("lin");
				}
			}
		};
		
		t1.start();
		t2.start();
		
		//运行结果
		//t1和t2并发跑着跑着，t2被中断，开始全部给t1运行完，然后再开始运行t2
		
	}
}
