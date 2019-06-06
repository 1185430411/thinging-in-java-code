package thinkinginjava;

public enum note{
	A,B,C;
}

class instrument{
	public void play(note n) {
		System.out.println("play.n");
	}
}

class guita extends instrument{
	public void play(note n) {
		System.out.println("guita.n");
	}
}



public class duotai {
	public static void tune(instrument i) {
		i.play(note.A);
	}
	public static void main(String[] args) {
		guita g=new guita();
		tune(g);
	}
}


/*
guita.n
*/
