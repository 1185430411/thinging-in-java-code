package Ten10;

class out{
	void f() {
		System.out.println("out");
	}
	
	class in{
		out make(){
			return out.this;                //利用this来构造外部类
		}
	}
	
	public in make() {
		return new in();
	}
}

public class thisANDnew {
	public static void main(String[] args) {
		out o=new out();
		out.in i=o.make();
		i.make().f();
	}
}


/*
测试结果：
out
*/
