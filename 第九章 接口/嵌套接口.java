package night9;

class monkey{
	interface shout{
		void shout1();
	}
	
	private interface cry1{                //类里面的嵌套接口的作用，为内部类提供接口
		void cry();
	}
	
	private class man1 implements cry1{
		public void cry() {}
	}
	
	public cry1 getcry1() {return new man1();}
	private cry1 c;
	public void receive(cry1 a) {
		c=a;
	}
}
	interface monkey1{
		interface man2{
			void cry2();
		}
		private interface man3{           //error:接口里面的嵌套接口必须是public的
			void cry3();
		}
	}

public class interfaceIn {
	public static void main(String[] args) {
		monkey m=new monkey();
		monkey.cry1 m1=m.getcry1();   //error：由于cry1是private的，不能这样构造
		m.receive(m.getcry1());       //ok：提供receive方法来构造
	}
}
