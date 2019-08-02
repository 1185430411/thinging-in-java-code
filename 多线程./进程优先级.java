package JAY01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
*使用setPriority方法来设置优先级
*取值范围为1-10，数字越大，优先级越大，被分到的时间片越多
*/



public class Test {
	public static void main(String[] args) {
		
		Thread t1=new Thread() {
			public void run() {
				for(int i=0;i<100;i++) {
					System.out.println("jay");
				}
			}
		};
		
		Thread t2=new Thread() {
			public void run() {
				for(int i=0;i<100;i++) {
					System.out.println("lin");
				}
			}
		};
		
		t1.setPriority(1);
		t2.setPriority(9);
		
		t1.start();
		t2.start();
		
		//系统不会把t2执行完了再执行t1.只给t2分配更多的时间片.运行结果是，前排更多是lin，后排更多是jay
	}
}
