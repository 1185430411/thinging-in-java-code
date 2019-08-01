package learn;

/*
 * 自定义泛型
 * 模仿泛型写一个泛型的类
 * */

class JAY<E>{
	private E e;
	public E getE() {
		return e;
	}
	
	public void setE(E e) {
		this.e=e;
	}
	
	public String toString() {
		return (String) e;
	}
}



public class learn{
	public static void main(String[] args) {
		JAY<String> j=new JAY<>();
		j.setE("10");
		System.out.println(j);    //10
		
	}
}
