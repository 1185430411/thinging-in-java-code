package Ten10;

interface animal{
	void run();
}

public class NiMing {
	public animal make() {
		return new animal() {
			public void run() {
				System.out.println("跑啊");
			}
		};
	}
	public static void main(String[] args) {
		NiMing n=new NiMing();
		animal a=n.make();
		a.run();
	}
}

//以上是匿名内部类的使用。是以下这个例子的简化版：
package Ten10;

interface animal{
	void run();
}

public class NiMing {
	class Myanimal implements animal{
		public void run() {
			System.out.println("跑啊");
		}
	}
	
	public animal make() {
		return new Myanimal();
	}
	public static void main(String[] args) {
		NiMing n=new NiMing();
		animal a=n.make();
		a.run();
	}
}

/*
测试用例：
跑啊
*/
