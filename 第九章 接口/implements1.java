package night9;

interface animal{
	int i=5;
	void run();
	void fly();
}

class human implements animal{
	public void run() {                             //通过接口写的方法必须是public
		System.out.println("跑啊");
	}
	public void fly() {
		System.out.println("不能飞");
	}
	
	void say() {
		System.out.println("人可以说话");
	}
}

class man extends human{
	public void run() {
		System.out.println("男生跑得更快");
	}
}



public class implements1 {
	public static void main(String[] args) {
		man m=new man();
		m.run();
	}
}


/*
男生跑得更快
*/
