package thinkinginjava;

import java.util.Random;

class shape{
	protected void draw() {}
}

class circle extends shape{
	protected void draw() {
		System.out.println("circle.draw");
	}
}

class square extends shape{
	protected void draw() {
		System.out.println("square.draw");
	}
}

class make{
	private Random r=new Random();
	public shape make1() {
		return new circle();
	}
}
public class duotai2 {
	private static make m=new make();
	public static void main(String[] args) {
		shape[] s=new shape[2];
		shape q=new circle();
		s[0]=m.make1();
		s[1]=m.make1();
		s[0].draw();
		s[1].draw();
		q.draw();
	}
}


/*
circle.draw
circle.draw
circle.draw
*/
