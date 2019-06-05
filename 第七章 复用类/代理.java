//为了防止shipcontrol的所有方法在DaiLi中完全暴露出来，采用代理的方法


package thinkinginjava;

class shipcontrol{
	void up(int i ) {}
	void down(int i ) {}
	void left(int i ) {}
	void right(int i ) {}
}


class shipcopy{
	private String name;
	private shipcontrol a=new shipcontrol();
	
	public shipcopy(String name) {
		this.name=name;
	}
	
	public void up(int i) {
		a.up(i);
		System.out.println(1);
	}
	public void down(int i) {
		a.down(i);
		System.out.println(2);
	}
	public void left(int i) {
		a.left(i);
		System.out.println(3);
	}
	public void right(int i) {
		a.right(i);
		System.out.println(4);
	}
}


public class DaiLi extends shipcopy{
	
	public DaiLi(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DaiLi a=new DaiLi("4");
		a.down(4);
	}
}

/*
测试结果：
2
*/


















