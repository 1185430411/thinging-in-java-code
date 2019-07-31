package learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
*迭代器Iterator可以直接对集合进行遍历，而无需用toArray方法转化成数组后再进行遍历
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
