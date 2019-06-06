package thinkinginjava;

class father{
	public static void staticprint() {
		System.out.println("father staticprint");
	}
	
	public void print() {
		System.out.println("father print");
	}
}


public class duotai3 extends father{
	public static void staticprint() {
		System.out.println("duotai3 static print");
	}
	
	public void print() {
		System.out.println("duotai3 print");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		father d=new duotai3();
		d.staticprint();
		d.print();
	}

}


/*
father staticprint
duotai3 print
*/

//若某个方法是静态的，则它的行为不具有多态性
