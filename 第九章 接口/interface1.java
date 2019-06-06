package night9;

interface fight{
	void fightable();
}

interface defence{
	void defenable();
}

interface shout extends fight,defence{
	void shoutable();
}

class hero2 implements shout{
	public void fightable() {
		System.out.println("可以打架");
	}
	public void defenable() {
		System.out.println("可以防守");
	}
	public void shoutable() {
		System.out.println("可以叫");
	}
}
public class implementses2 {
	static void aaa(shout s) {
		s.shoutable();
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		implementses2 i=new implementses2();
		i.aaa(new hero2());                                //在接口上，hero也可以向上转型，成为形参接口
	}
}


/*
测试结果：
可以叫
*/
