package learn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


	

public class learn{
	public static void main(String[] args) {
		//把一个字符串按照顺序输出，且保留重复元素。如java，输出aajv
		String s="java";
		char[] c=s.toCharArray();
		/*因为Character是系统自有的类。不能像person一样去重写compareTo（其实也可以，只是有点大动干戈）。这时可以
		 * 在构造TreeSer集合时构造一个新的比较器*/
		TreeSet<Character> ts=new TreeSet<Character>(new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
				// TODO Auto-generated method stub
				int num=c1.compareTo(c2);
				if(num==0) num=1;//确保重复的元素也会被存放
				return num;
			}
		});
		
		for(Character ch:c) {
			ts.add(ch);
		}
		for(Character ch1:ts) {
			System.out.print(ch1);   //aajv
		}
	}
}
