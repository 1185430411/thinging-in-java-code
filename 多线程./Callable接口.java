package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 使用Callable接口来实现多线程方法：
 * 1.编写自定义类，实现Callable接口（有泛型）
 * 2.重写call方法。并在call方法中编写线程要执行的内容
 * 3.利用ExecutorService来创建线程池.要调用Executors中的newFixedThreadPool方法来进行构造
 * 4.对线程池对象用submit方法来添加线程，并用Future类对象来接收结果
 * 5.Future.get()方法查看线程运行结果
 * 6.对线程池对象调用shutdown方法来关闭线程池。
 */



class myThread implements Callable<Integer>{
	private int num;
	public myThread(int num) {
		this.num=num;
	}
	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=0;i<num;i++) {
			sum+=num;
		}
		return sum;
	}
	
}

public class Test {
	public static void main(String[] args) {
		//创建线程池。线程池可以保存线程，减少过去使用过的线程的重新创造，提高效率
		ExecutorService es=Executors.newFixedThreadPool(2);//传入参数为创建线程数量
		Future<Integer> f1=es.submit(new myThread(5));   //Future类来接收结果
		Future<Integer> f2=es.submit(new myThread(3));
		
		try {
			if(f1.isDone()) {
				System.out.println(f1.get());
			}else {
				System.out.println("线程1还未执行完毕");
			}
			if(f2.isDone()) {
				System.out.println(f2.get());
			}else {
					System.out.println("线程2还未执行完毕");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();  //线程池被关闭时，线程还可以运行
		System.out.println("main结束"); 
		
		//线程1还未执行完毕
		//4
		//main结束
		//(结果每次不同，取决于运行效果)

		
	}
}
