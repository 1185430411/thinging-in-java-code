package thinkinginjava;

public class KeBianCanShu {
	static void f(int...args) {
		System.out.println("first");
		for(int a:args) {
			System.out.print(a+" ");
		}
	}
	
	static void g(String...args) {
		System.out.println("second");
		for(String s:args) {
			System.out.print(s);
		}
	}
	
	public static void main(String[] args) {
		f(1,2,3,5);
		System.out.println();
		g("monday","tuesday","wednesday");
	}
}

/*
first
1 2 3 5 
second
mondaytuesdaywednesday
*/
