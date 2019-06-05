package thinkinginjava;

class cup{
	cup(int i){
		System.out.println("cup"+i);
	}
	void f(int i) {
		System.out.println("f"+i);
	}
}

class cups{
	static cup cup1;
	static cup cup2;
	static {
		cup1=new cup(1);
		cup2=new cup(2);
	}
	cups(){
		System.out.println("cupsconstructor");
	}
}

public class usestatic1 {
	public static void main(String[] args) {
		System.out.println("main");
		cups d=new cups();                  //main里面创造类才有用，结果：cupsconstructor
	}
	
	static cups a=new cups();               //cups里的static方法，只被执行一次
	static cups b=new cups();
	cups c=new cups();                      //除非加上static，否则无结果
}


/*
测试结果：
1
2
cupsconstructor
cupsconstructor
main
cupsconstructor
*/
