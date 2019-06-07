package Ten10;

class test {
	
	class man{
		public void print() {
			System.out.println("man");
		}
	}
	
	class woman{
		public void print() {
			System.out.println("woman");
		}
	}
	
	public man make() {
		return new man();
	}
}
public class inclass{
	public static void main(String[] args) {
		//man m1=new man();   //error:不能直接调用内部类
		test t=new test();
		test.man m3=t.make();                
		m3.print();
	}
}

/*
测试结果
man
*/
