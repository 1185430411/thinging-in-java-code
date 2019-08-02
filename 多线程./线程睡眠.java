package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;





public class Test {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				for(int i=10;i>=0;i--) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} //睡眠一秒
					System.out.println(i);
				}
			}
		}.start();
		//效果:每隔一秒输出一个数字
		
		new Thread() {
			public void run() {
				for(int i=0;i<10;i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("jay");
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				for(int i=0;i<10;i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("lin");
				}
			}
		}.start();
		
		//交替运行，都等待1s
	}
}
