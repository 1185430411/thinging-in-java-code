package learn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class learn{
	public static void main(String[] args) {
		Map<Integer,String> map=new HashMap<>();
		map.put(1, "周杰伦");
		map.put(2, "林书豪");
		map.put(3, "林俊杰");
		map.put(4, "陈奕迅");
		String s1=map.put(3, "五月天");
		System.out.println(s1);    //林俊杰  会把删除的元素作为返回值（String类）
		String s2=map.put(5, "王力宏");
		System.out.println(s2);   //null
		
		System.out.println(map);  //{1=周杰伦, 2=林书豪, 3=五月天, 4=陈奕迅, 5=王力宏}
		
		map.remove(5);
		System.out.println(map);  //{1=周杰伦, 2=林书豪, 3=五月天, 4=陈奕迅}
		
		System.out.println(map.containsKey(1));   //true
		System.out.println(map.containsValue("周杰伦"));  //true
		
		System.out.println(map.get(1));  //周杰伦
		
		System.out.println(map.size());   //4
		
		Collection<String> c=map.values();  //values函数，把value值以Collection集合方式返回
		
		System.out.println(c);  //[周杰伦, 林书豪, 五月天, 陈奕迅]
		
	}
}
