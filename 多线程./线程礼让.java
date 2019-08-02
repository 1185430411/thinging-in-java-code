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
				for(int i=0;i<5;i++) {
					System.out.println("领导");
				}
			}
		};
		
		Thread t2=new Thread() {
			public void run() {
				for(int i=0;i<5;i++) {
					if(i%2==0) {
						//若满足条件，则进行礼让
						Thread.yield();   //让线程2暂停一小会
					}
					System.out.println("员工");
				}
			}
		};
		
		t1.start();
		t2.start();
		
		//运行结构是，前排领导更多，后排员工更多
	}
}
