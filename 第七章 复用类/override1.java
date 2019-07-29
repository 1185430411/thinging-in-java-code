package thinkinginjava;

class homer{
	int doh(int i) {
		System.out.println("int");
		return i;
	}
	
	char doh(char i) {
		System.out.println("char");
		return i;
	}
}

class houser{}

class bart extends homer{
	houser doh(houser h) {
		System.out.println("houser");
		return h;
	}
}

public class overrides {
	public static void main(String[] args) {
		bart b=new bart();
		b.doh(4);
		b.doh('a');
		b.doh(new houser());
	}
}


/*
int
char
houser
*/
