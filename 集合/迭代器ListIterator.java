package learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * */
public class learn{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		List list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("jayice");
		list.add("c");
		
		
		//判断集合中是否有"jayice"元素，若有，则往集合中添加一个"1024";
		
		
		@SuppressWarnings("rawtypes")
		Iterator it=list.iterator();
		while(it.hasNext()) {
			String s=(String)it.next();//next方法返回一个Object类的元素，需要进行强制转型
			if("jayice".equals(s)) list.add("1024");  //Exception
		}
		
		//在迭代器的循环中，不能对集合进行元素的增删，否则会影响长度，影响hasNext。
		
		//可以这样操作.ListIterator迭代器有一个add方法，可以在循环中给集合添加元素
		 
		 
	
		@SuppressWarnings("rawtypes")
		ListIterator li=list.listIterator();
		while(li.hasNext()) {
			String s=(String)li.next();
			if("jayice".equals(s)) li.add("1024");
		}
		System.out.println(list);  //[a, b, jayice, 1024, c]
	}
}
