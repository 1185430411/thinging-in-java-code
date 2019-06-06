package thinkinginjava;
class grandpa{
	public grandpa(){
		System.out.println("grandpa");
	}
}

class son extends grandpa{
	public son() {
		System.out.println("father");
	}
}

public class duotai4 extends son{
	@SuppressWarnings("unused")
	private grandpa g=new grandpa();
	@SuppressWarnings("unused")
	private son s=new son();
	public static void main(String[] args) {
		System.out.println("in the main");
		new duotai4();
	}
}


/*
in the main
grandpa
father
grandpa
grandpa
father
*/
