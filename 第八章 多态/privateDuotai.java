package thinkinginjava;

class dog extends privateduotai{
	public void fly() {
		System.out.println("public");
	}
}

public class privateduotai {
	private void fly() {
		System.out.println("private");
	}
	
	public static void main(String[] args) {
		privateduotai p=new dog();
		p.fly();
	}
}


/*
private
*/

//非private方法才可以被覆盖
