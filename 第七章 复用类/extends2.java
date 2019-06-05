package thinkinginjava;

class iron{
	public iron(int i) {
		System.out.println("iron");
	}
}

class spoon extends iron{
	public spoon(int i) {
		super(i);
		System.out.println("spoon");
	}
}

class knife extends iron{
	public knife(int i) {
		super(i);
		System.out.println("knife");
	}
}

public class dinner {
	private knife knife;
	private spoon spoon;

	public dinner() {
		// TODO Auto-generated constructor stub
		knife=new knife(4);
		spoon=new spoon(4);
		System.out.println("dinner");
	}
	public static void main(String[] args) {
		dinner d=new dinner();
	}

}

/*
iron
knife
iron
spoon
dinner
*/
