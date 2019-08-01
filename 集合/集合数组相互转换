package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class learn{
	public static void main(String[] args) {
		//集合转化为数组
		List<String> l=new ArrayList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		String[] s1=l.toArray(new String[2]); //自动补充到3
		System.out.println(s1.length);   //3
		System.out.println(s1[2]);   //c
		
		String[] s2=l.toArray(new String[5]);
		System.out.println(s2.length);   //5
		
		

		//数组转化为集合
		String[] s3= {"a","b","c","d"};
		List<String> l2=Arrays.asList(s3);
		System.out.println(l2);      //[a, b, c, d]
	}
}
