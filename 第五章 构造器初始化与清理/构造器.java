package thinkinginjava;

class rock{
	rock(int i){
		System.out.println("hello world"+i);;
	}
	
	public int throw1() {
		return 5;
	}
}


public class constructor {
	public static void main(String []args) {
		for(int i=0;i<10;i++)
			new rock(i);
		
		@SuppressWarnings("unused")
		rock a=new rock(1);                  //构造器中的操作将会自动执行
		System.out.println((a.throw1()));
	}
}


/*
测试结果：
hello world0
hello world1
hello world2
hello world3
hello world4
hello world5
hello world6
hello world7
hello world8
hello world9
hello world1
5

*/
