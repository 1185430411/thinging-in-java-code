//内部类不可能在外部类没被构建时被构建，


package Ten10;

class out1{
	void print1() {
		System.out.println("out1");
	}
	class in1{
		void print1() {
			System.out.println("in1");
		}
	}
}

public class innernew {
	public static void main(String[] args) {
		out1 o=new out1();
		out1.in1 i=o.new in1();   //使用new，通过o来构建内部类
    i.print1();
	}
}

/*
测试结果：
in1
*/
