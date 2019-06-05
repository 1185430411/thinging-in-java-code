package thinkinginjava;

class water{
	private String s;
	water(){
		System.out.println(666);
		s="hello";
	}
	public String toString() {
		return s;
	}
}

public class change {
	private String a;
	private water w=new water();
	public String toString() {
		return "i say"+w;
	}
	
	public static void main(String[] args) {
		change c=new change();
		System.out.println(c);  //c并不是一个可以打印的东西，编译器自动使用toString方法，将其转化为字符串。若在change中没有进行重写toString方法，则默认方法会将其转化为 名字+@+地址
	}
}


/*
666
i sayhello
*/
