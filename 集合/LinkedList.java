package learn;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Vector;

/*
 * vector集合被用得很少
 * 了解即可
 * */
public class learn{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		LinkedList ll=new LinkedList();
		//模拟栈Stack
		//push
		ll.add(1);
		ll.add(2);
		ll.add(3);
		System.out.println(ll);  //[1, 2, 3]
		
		//pop
		ll.removeLast();
		System.out.println(ll);  //[1, 2]
		
		
		//top
		System.out.println(ll.getLast()); //2
		
		
		//模拟队列Queue
		LinkedList l=new LinkedList();
		//push
		l.add(1);
		l.add(2);
		l.add(3);
		System.out.println(l);  //[1, 2, 3]
		
		//pop
		l.removeFirst();
		System.out.println(l);  //[2, 3]
		
		//front
		
		System.out.println(l.getFirst());  //2

		
		
	}
}
