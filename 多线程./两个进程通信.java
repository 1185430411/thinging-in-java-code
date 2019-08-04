package JAY01;

class wow {
	private int flag = 1;

	public void method1() {
		synchronized (this) {
			if (flag != 1) {
				try {
					// 若flag不为1，则线程进入等待序列（类似中断）
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 否则输出2，并把信号量置为2
			System.out.println("jay");

			flag = 2;
			this.notify();
		}
	}

	public void method2() {
		synchronized (this) {
			if (flag != 2) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("ice");

			flag = 1;
			this.notify();
		}
	}

}

public class Test {
	public static void main(String[] args) {
		wow w = new wow();
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					w.method1();
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					w.method2();
				}
			}
		};

		t1.start();
		t2.start();
	}
}
