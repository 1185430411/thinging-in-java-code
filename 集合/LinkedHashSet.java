package learn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class learn{
	public static void main(String[] args) {
		//List中的元素可重复，且按照写入顺序存储、
		//HashSet中的元素不可重复，不按写入顺序储存，而是按照HashCode算法来进行储存
		//LinkedHashSet中的元素不可重复，按写入顺序储存
		/*把List中的元素去重，可利用LinkedHashSet*/
		
		List<String> l=new ArrayList<>();
		l.add("a");
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("c");
		System.out.println(l);  //[a, a, b, c, c]

		LinkedHashSet<String> lhs=new LinkedHashSet<>();
		lhs.addAll(l);
		System.out.println(lhs);   //[a, b, c]
		l.clear();
		l.addAll(lhs);
		System.out.println(l);    //[a, b, c]
		
	}
}
