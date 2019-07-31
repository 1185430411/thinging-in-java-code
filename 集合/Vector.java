package learn;

import java.util.Enumeration;
import java.util.Vector;

/*
 * vector集合被用得很少
 * 了解即可
 * */
public class learn{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Vector res=new Vector();
		res.addElement("a");
		res.addElement("b");
		res.addElement("c");
		@SuppressWarnings("rawtypes")
		Enumeration er=res.elements();
		while(er.hasMoreElements()) {
			System.out.print(er.nextElement());  //abc
		}
		System.out.println();
		System.out.print(res.get(1));  //b
	}
}
