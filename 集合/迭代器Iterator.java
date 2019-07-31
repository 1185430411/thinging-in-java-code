package learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * */
public class learn{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
			@SuppressWarnings("rawtypes")
			Collection c=new ArrayList();
			c.add(1);
			c.add(2);
			c.add(3);
			c.add(4);
			@SuppressWarnings({ "rawtypes", "unused" })
			Iterator it=c.iterator();  //多态
			while(it.hasNext()) {
				System.out.print(it.next()+" ");
			}
	}
}
