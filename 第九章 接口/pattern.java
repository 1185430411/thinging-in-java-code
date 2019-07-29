package night9;

class father{
	Object way(Object obj) {
		return  obj;
	}
}

class low extends father{
	String way(Object s) {              //参数也必须相同，否则直接调用父类的way方法
		return ((String)s).toLowerCase();
	}
}

class up extends father{
	String way(Object s) {
		return ((String)s).toUpperCase();
		}
}


public class pattern {
	public static void way(father f,Object obj) {             //通过不同参数来调不同的方法
		System.out.println(f.way(obj));
	}
	public static void main(String[] args) {
		way(new low(),"abc");
		way(new up(),"abc");
	}
}


/*
abc
ABC
*/
