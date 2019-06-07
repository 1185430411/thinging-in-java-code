package Ten10;

interface service1{
	void method();
}

interface serviceFactory{
	service1 make();
}

class one implements service1{
	public void method() {
		System.out.println("method1");
	}
	public serviceFactory factory() {
		return new serviceFactory() {
			public service1 make() {
				return new one();
			}
		};
	}
}

class two implements service1{
	public void method() {
		System.out.println("method2");
	}
	public serviceFactory factory() {          
		return new serviceFactory() {              //匿名内部类
			public service1 make() {
				return new two();
			}
		};
	}
}

public class NiMingAndFac {
	public static void operate(serviceFactory f) {
		service1 s=f.make();
		s.method();
	}
	public static void main(String[] args) {
		operate(new one().factory());
		operate(new two().factory());
	}
}

/*
测试用例：
method1
method2
*/
