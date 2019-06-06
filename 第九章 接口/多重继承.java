package night9;

interface fly{
	void flyable();
}


interface run{
	void runable();
}

class hero implements fly,run{
	public void flyable() {
		System.out.println("可以飞");
	}
	public void runable() {
		System.out.println("可以跑");
	}
}
public class implementses {
	public static void main(String[] args) {
		hero h=new hero();
		h.flyable();
		h.runable();
	}
}
