package learn;

import java.math.BigDecimal;

/*
 * */
public class learn{
	public static void main(String[] args) {
		System.out.println(2.0-1.1);   //0.8999999999999999
		
		BigDecimal bd1=new BigDecimal(2.0);
		BigDecimal bd2=new BigDecimal(1.1);
		System.out.println(bd1.subtract(bd2));   //0.8999999999999999
		
		//开发时要使用这两种，运算精确
		BigDecimal bd3=new BigDecimal("2.0");
		BigDecimal bd4=new BigDecimal("1.1");
		System.out.println(bd3.subtract(bd4));  //0.9
		
		BigDecimal bd5=BigDecimal.valueOf(2.0);
		BigDecimal bd6=BigDecimal.valueOf(1.1);
		System.out.println(bd5.subtract(bd6));  //0.9
	}
}
