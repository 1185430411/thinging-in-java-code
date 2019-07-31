package learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
 * */
public class learn{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings({ "rawtypes", "unused" })
		List list =new ArrayList();   //List是一个接口，要通过连接它的ArrayList来实现构造
		list.add("a");
		list.add("c");
		list.add("d");
		System.out.println(list);  //[a, c, d]
		
		list.add(1, "b");
		System.out.println(list);  //[a, b, c, d]
		
		list.remove(0);       //删除索引为0的元素
		System.out.println(list);  //[b, c, d]
		  
		list.remove("b");            //删除内容为b的元素
		System.out.println(list);  //[c, d]
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");   //c d    //get用于获取元素内容
		}
		System.out.println();
		
		list.set(0, "a");        //把索引为1处的元素set为a
		System.out.println(list);  //[a, d]
		
		
		//模拟栈
		//push
		list.add(list.size()-1, "e");
		System.out.println(list); //[a, e, d]
		
		//pop();
		list.remove(list.size()-1);
		System.out.println(list); //[a, e]

	}
}
