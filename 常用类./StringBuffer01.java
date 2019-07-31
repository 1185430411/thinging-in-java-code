package learn;

/*
 * StringBuffer底层是一个char型数组，默认创建一个长度为16的char型数组，能自动通过拷贝增加数组的长度，提高效率
 * StringBuffer类和StringBuilder类的方法相同，区别在于：
 * 1.StringBuffer类线程安全，效率低
 * 2.StringBuilder类线程不安全，效率高
 * */
public class learn{
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		System.out.println(sb.capacity());    //16
		
		StringBuffer sb1=new StringBuffer(100);
		System.out.println(sb1.capacity());    //100
		
		StringBuffer sb2=new StringBuffer("JAYICE");
		System.out.println(sb2.capacity());     //22(6+16)
	}
}
