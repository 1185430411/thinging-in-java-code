package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class task{
	private int num=10;
	
	//synchronized关键字:同步。即设立临界区，只有一个线程对资源的访问结束后，另一个进程才能进入
	public void changNum(boolean flag) {
		//16-22是一段不涉及线程安全的任务,，即这块区域不需要同步
		try {
			//模拟执行一个耗时较长的任务
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//真正实际线程安全的代码，用synchronized关键字套起来。相当于设立临界区
		synchronized(this){
			if (flag) num=88;
			else num=66;
			System.out.println(num);
		}
		
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
	
	//66
	//88


		
	}
}
