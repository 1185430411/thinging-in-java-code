package night9;

interface service{
	void a();
}
interface serviceFactory{
	service get();
}

class implementation1 implements service{
	public void a() {
		System.out.println("method 1");
	}
}

class implementation1Factory implements serviceFactory{
	public service get() {
		return new implementation1();
	}
}

class implementation2 implements service{
	public void a() {
		System.out.println("method 2");
	}
}
class implementation2Factory implements serviceFactory{
	public service get() {
		return new implementation2();
	}
}

public class factory {
	
	public static void make(serviceFactory s) {              //指定参数为service，在main下就可自由填入service接口的类，向上转型。而无需写多个函数来对应不同的implmentation
		s.get();
	}
	public static void main(String[] args) {
		make(new implementation1Factory());
		make(new implementation2Factory());
	}
}


/*
method 1
method 2
*/
