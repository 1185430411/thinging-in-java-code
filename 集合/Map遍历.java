package learn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class learn{
	public static void main(String[] args) {
		Map<Integer,String> map=new HashMap<>();
		map.put(1, "周杰伦");
		map.put(2, "林书豪");
		map.put(3, "林俊杰");
		map.put(4, "陈奕迅");
		
		Set<Integer> s=map.keySet();  //返回一个Set集合，因为Set的底层数据结构就是哈希表。而且元素不能重复，正好符合key
		Iterator<Integer> i=s.iterator();
		while(i.hasNext()) {
			int key=i.next();
			System.out.println("K："+key+" V:"+map.get(key));
			//K：1 V:周杰伦
   			//K：2 V:林书豪
			//K：3 V:林俊杰
			//K：4 V:陈奕迅
		}
		
		//方法2
		Set<Map.Entry<Integer, String>> s1=map.entrySet(); //返回一个entry类型，entry类型也是一个map元素
		Iterator <Map.Entry<Integer, String>>i1=s1.iterator();
		while(i1.hasNext()) {
			Map.Entry<Integer, String> et=i1.next();
			System.out.println("K: "+et.getKey()+" V:"+et.getValue());
			//K: 1 V:周杰伦
			//K: 2 V:林书豪
			//K: 3 V:林俊杰
			//K: 4 V:陈奕迅
		}
		
	}
}
