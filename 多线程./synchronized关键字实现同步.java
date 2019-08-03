package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class task{
	private int num=10;
	
	//synchronized关键字:同步。即设立临界区，只有一个线程对资源的访问结束后，另一个进程才能进入
	public synchronized void changNum(boolean flag) {
		if(flag) num=88;
		else num=66;
		System.out.println(num);
	}
}


public class Test {
	public static void main(String[] args) {
	
	task t=new task();
	
	//两个线程都访问了同一块资源，造成了线程安全问题
	Thread t1=new Thread() {
		public void run() {
			t.changNum(true);
		}
	};
	
	Thread t2=new Thread() {
		public void run() {
			t.changNum(false);
		}
	};
	
	t1.start();
	t2.start();
	
	//不加synchronized的运行结果：
	//66
	//66
	
	
	//加上synchronized运行结果：
	//88
	//66

	
		
		
	}
}
