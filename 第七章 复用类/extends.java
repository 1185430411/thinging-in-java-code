package thinkinginjava;

class animal{
	private String a="animal can ";
	public void append(String s) {
		a+=s;
	}
	public void shout() {
		append("aaa");
	}
	public void cry() {
		append("555");
	}
	public String toString() {
		return a;
	}
	public static void main(String[] args) {
		animal x=new animal();
		x.shout();
		x.cry();
		System.out.println(x);
	}
}

public class testextends extends animal{
	public void shout() {
		append("汪汪汪");
		super.shout();            //使用父类的shout
	}
	public void fly() {
		append("feifei");
	}
	
	public static void main(String[] args) {
		testextends a=new testextends();
		a.shout();
		a.cry();
		a.fly();
		System.out.println(a);
		animal.main(args);
	}
}


/*
animal can 汪汪汪aaa555feifei
animal can aaa555
*/
