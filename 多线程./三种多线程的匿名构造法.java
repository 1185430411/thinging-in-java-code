package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;





public class Test {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//Thread
		new Thread() {
			public void run() {   //重写
				for(int i=0;i<200;i++) {
					System.out.println("jay");
				}
			}
		}.start();  //启动线程
		
		//Runnable
		new Thread(new Runnable() {
			public void run() {      //重写
				for(int i=0;i<200;i++) {
					System.out.println("lin");
				}
			}
		}).start();  //启动线程
		
		
		//Callable
		ExecutorService es=Executors.newCachedThreadPool();  //创建线程池
		
		Future<Integer> f1=es.submit(new Callable<Integer>(){     //Future类来接收
			public Integer call()throws Exception{   //重写call方法
				return 88;
			}
		});
		
		System.out.println(f1.get());  //获取结果
		
		//运行结果是jay和lin交替或连续输出，88可能输出在任何一个位置
	}
}
