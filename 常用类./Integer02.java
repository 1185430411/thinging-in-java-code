package learn;

/*
 * */
public class learn{
	public static void main(String[] args) {
		//int->Integer
		Integer i1=new Integer(19);
	
		//Integer->int
		int a=i1.intValue();
		
		//String->Integer
		Integer i2=new Integer("20");
		
		//Integer->String
		String s=i2.toString();
		
		//String->int
		int b=Integer.parseInt("300");
		
		//int->String
		String s2=a+"";
	}
	
}
