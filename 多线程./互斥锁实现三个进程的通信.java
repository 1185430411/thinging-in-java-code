package JAY01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class wow {
	private int flag = 1;
	private ReentrantLock r = new ReentrantLock(); // 互斥锁 可以取代synchronized关键字
	private Condition c1 = r.newCondition();// 线程监听
	private Condition c2 = r.newCondition();// 线程监听
	private Condition c3 = r.newCondition();// 线程监听

	public void method1() {
		r.lock();
		while (flag != 1) {
			try {
				// 若flag不为1，则线程进入等待序列（类似中断）
				c1.await(); // 利用监听把线程进行中断
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 否则输出2，并把信号量置为2
		System.out.println("jay");
		flag = 2;
		c2.signal(); // 对指定线程进行唤醒
		r.unlock(); // 退出临界区
	}

	public void method2() {
		r.lock();
		while (flag != 2) {
			try {
				c2.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("ice");

		flag = 3;
		c3.signal();
		r.unlock();
	}

	public void method3() {
		r.lock();
		while (flag != 3) {
			try {
				c3.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("666");

		flag = 1;
		c1.signal();
		r.unlock();
	}

}

public class Test {
	public static void main(String[] args) {
		wow w = new wow();
		Thread t1 = new Thread() {
			int i=100;
			public void run() {
				while (i>0) {
					w.method1();
					i--;
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				int i=100;
				while (i>0) {
					w.method2();
					i--;
				}
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				int i=100;
				while (i>0) {
					w.method3();
					i--;
				}
			}
		};

		t1.start();
		t2.start();
		t3.start();
		
		//
		//jay
		//ice
		//666
		//（交替打印，实现三个线程的通信）
	}
}
