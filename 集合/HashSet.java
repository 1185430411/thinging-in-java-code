package learn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class learn{
	public static void main(String[] args) {
		Set<String> s=new HashSet<>();
		s.add("a");
		s.add("c");
		s.add("f");
		s.add("b");
		s.add("d");
		s.add("e");
		s.add("Z");
		System.out.println(s);   //[a, b, c, d, e, f, Z]  可见，存储顺序与添加顺序无关，原理和数据结构里的哈希表一样，按照一定的函数去存储索引
		
		@SuppressWarnings("rawtypes")
		Iterator i=s.iterator();
		while(i.hasNext()) {
			System.out.print(i.next());   //abcdefZ
		}
	}
}
