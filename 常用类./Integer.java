package learn;

/*包装类能保证数据能更好地处理，并且能够转换
*除了char的包装类名是Character int的包装类名是Integer。其他数据类型的包装类都是首字母大写，如long的包装类名是Long
 * */
public class learn{
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);  //2147483647
		System.out.println(Integer.MIN_VALUE);  //-2147483648
		
		Integer i1=new Integer(10);
		System.out.println(i1);    //10
		int a=i1.intValue();       //将Integer转化为int型
		System.out.println(a);     //10
		
		
		int b=Integer.parseInt("100");  //将String型转化为int型（String的内容必须是数字，否则会报错）
		System.out.println(b);    //100
		Integer i2=new Integer("666");  //也可以通过String来构造Integer
		Integer i3=Integer.valueOf(999);//int转化为Integer
		System.out.println(i3);     //999
		
	}
	
}
