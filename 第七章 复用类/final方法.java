package thinkinginjava;

class chess{
	private void go() {                  //private的方法可以被重写
		System.out.println("go1");
	}
}

class mate extends chess{
	public void go() {                  //若public改为private，则main里面的m.go()无法通过编译
		System.out.println("go2");
	}
}

class girl extends mate{
	public void go() {
		System.out.println("go3");
	}
}

class mate1 extends chess{
	public final void go() {             //final的方法不能被重写
		System.out.println("go4");
	}
}

class girl1 extends mate1{
	public void go() {                   //error
		System.out.println("go5");
	}
}


public class Tfinalprivate extends chess{
	public static void main(String[] args) {
		mate m=new mate();
		m.go();                           //error
		girl g=new girl();
		g.go();
	}
}
