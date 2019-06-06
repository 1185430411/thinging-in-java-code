package thinkinginjava;
class pa{
	public void write() {                //public改为private，则输出结果的er变为pa
		System.out.println("pa");
	}
	public pa() {
		System.out.println("before");
		write();
		System.out.println("after");
	}
}

class er extends pa{
	public void write() {
		System.out.println("er");
	}
}

public class overwrite{
	public static void main(String[] args) {
		new er();
	}
}


/*
测试结果：
before
er
after
*/
