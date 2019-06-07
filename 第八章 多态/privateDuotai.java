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

/*
private方法可以被重写，但涉及多态时，private方法无法被覆盖
非private方法才可以被覆盖
*/
