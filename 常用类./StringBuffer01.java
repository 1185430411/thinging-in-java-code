package learn;

/*
 * StringBuffer底层是一个char型数组，默认创建一个长度为16的char型数组，能自动通过拷贝增加数组的长度，提高效率
 * 
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
