package thinkinginjava;

class animal1{
	animal1(){
		System.out.println("animal");
	}
	
	public void clear() {
		System.out.println("animal clear done");
	}
}

class human extends animal1{
	private animal1 a=new animal1();
	human(){
		System.out.println("human");
	}
	public void clear() {
		a.clear();
		System.out.println("human clear done");
		super.clear();
	}
}

class man extends human{
	private animal1 b=new animal1();
	man(){
		System.out.println("man");
	}
	public void clear() {
		b.clear();
		System.out.println("man clear done");
		super.clear();
	}
}

public class extendsAndClear extends man{
	private animal1 c=new animal1();
	public void clear() {
		c.clear();
		System.out.println("extendsAndClear clear done");
		super.clear();
	}
	public static void main(String[] args) {
		System.out.println("in the main");
		extendsAndClear e=new extendsAndClear();
		System.out.println("mid");
		e.clear();
	}
}


/*
in the main
animal
animal
human
animal
man
animal
mid
animal clear done
extendsAndClear clear done
animal clear done
man clear done
animal clear done
human clear done
animal clear done
*/







