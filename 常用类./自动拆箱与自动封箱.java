package learn;

/*
 * */
public class learn{
	public static void main(String[] args) {
		//自动装箱
		Integer i1=1000;
		Integer i2=1000;
		
		System.out.println(i1==i2);    //false
		System.out.println(i1.equals(i2));  //true
		
		//自动拆箱
		int a=i1;
		int b=i2;
		System.out.println(a==b);   //true
		
		Integer i3=127;
		Integer i4=127;
		/*
		 * java有整型常量池的概念
		 * 若int在-128到127之间，直接从常量池中获取，无需再new出来一个新的Integer
		 * 故此时比较结果是true
		 * */
		System.out.println(i3==i4);  //true
		
		

	}
}
