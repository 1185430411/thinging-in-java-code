package learn;

/*
 *方法中传入一个基础数据类型，原数据的值不会被改变
 *方法中传入一个引用数据类型，原数据的值会被改变
 * */
public class learn{
	public static void main(String[] args) {
		String s="jayice";
		System.out.println(s);   //jayice
		change(s);
		System.out.println(s);   //jayice
		
		StringBuffer sb=new StringBuffer(20);
		sb.append("jayicebuffer"); 
		System.out.println(sb);       //jayicebuffer
		change(sb);
		System.out.println(sb);       //jayicebufferjava
		
	}
	
	public static void change(String s) {
		s+="java";
	}
	
	public static void change(StringBuffer sb) {
		sb.append("java");
	}
}
