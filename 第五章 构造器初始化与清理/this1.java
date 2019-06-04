package thinkinginjava;

class rock1{
	static stone throw1(stone a) {
		System.out.println(666);
		return a;
	}
}

class stone{
	stone throw2() {
		return (rock1.throw1(this));       //利用this，把自身当作形式参数传给rock1类的throw1方法中
	}

}

public class noconstructor {
	public static void main(String[] args) {
		stone a=new stone();              
		a.throw2();
	}
}



/*
测试结果：
666
*/
