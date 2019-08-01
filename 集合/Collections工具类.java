package learn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class learn{
	public static void main(String[] args) {
		//Collections工具类  不是Collection（接口）。前者是一个类似于Arrays的工具类
		List<Integer> l=new ArrayList<>();
		l.add(1);
		l.add(3);
		l.add(6);
		l.add(9);
		
		Collections.sort(l); //排序
		System.out.println(l);//[1, 3, 6, 9]
		
		Collections.reverse(l); //倒转
		System.out.println(l); //[9, 6, 3, 1]
		
		Collections.shuffle(l); //随机排序
		System.out.println(l);  //[1, 9, 3, 6]
	}
}
