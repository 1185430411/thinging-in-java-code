package learn;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/*
 * */
public class learn{
	public static void main(String[] args) {
		String s=DecimalFormat.getCurrencyInstance().format(1234567);  //转化为人民币格式
		System.out.println(s);   //￥1,234,567.00
		
		DecimalFormat df=new DecimalFormat("$###,###.####");  //自定义格式
		System.out.println(df.format(1234567.1));    //$1,234,567.1
		
		DecimalFormat df2=(DecimalFormat) DecimalFormat.getCurrencyInstance();
		System.out.print(df2.format(123));      //￥123.00
	}
}
