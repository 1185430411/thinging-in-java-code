package learn;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/*
 * */
public class learn{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList a=new ArrayList();  //内容为Object
		a.add(5);
		a.add(4);
		a.add("a");
		System.out.println(a);  //[5, 4, a] 
		
		a.remove("a");
		System.out.println(a); //[5, 4]
		
		System.out.println(a.contains(5));  //true
		
		System.out.println(a.isEmpty());  //false
		
		a.clear();
		System.out.println(a.isEmpty());  //true
	}
}
