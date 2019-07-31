package learn;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/*
 * vector集合被用得很少
 * 了解即可
 * */
public class learn{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList();
		q.add(1);
		q.add(2);
		q.add(3);
		q.remove();
		System.out.println(q);  //[2, 3]
		
		System.out.println(q.isEmpty());   //false
		
		int a=q.peek();    //获取队列头
		System.out.println(a);
		System.out.println(q);
		
		int b=q.poll();   //队列进行出队操作，并把出队的元素返回
		System.out.println(b);
		System.out.println(q);
		
		
		@SuppressWarnings("unused")
		Stack<Integer> s=new Stack<>();
		s.add(1);
		s.add(2);
		s.add(3);
		System.out.println(s);  //[1, 2, 3]
		
		int c=s.pop();
		System.out.println(c);   //3
		System.out.println(s);   //[1, 2]
		
		System.out.println(s.isEmpty());   //false
		
	}
}
