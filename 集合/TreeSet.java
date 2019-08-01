package learn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


class person implements Comparable<person>{
	private int age;
	private String name;
	public person(String name,int age) {
		this.age=age;
		this.name=name;
	}
	
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age=age;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	
	public String toString() {
		return "[姓名："+name+" 年龄：" +age+"]";
	}
	public boolean equals(person p) {
		if(this==p) return true;
		if(p==null) return false;
		if(p.name.equals(name)&&p.age==age) return true;
		return false;
		
	}
	/*
	 * TreeSet集合底层数据结构是二叉树
	 * compareTo方法决定储存方式
	 * 当compareTo返回值为正数时，则证明该值较大，存在右边；若为负数，则存在左边，若为0，则相等，二叉树不储存两个相等的元素
	 * 所以return 1.输出顺序与写入顺序相同，即[[姓名：张三 年龄：21], [姓名：李四 年龄：22], [姓名：王五 年龄：23]]
	 * 若return -1.则输出顺序与写入顺序相反，即[[姓名：王五 年龄：23], [姓名：李四 年龄：22], [姓名：张三 年龄：21]]
	 * 若想要按照年龄大小进行储存，则:
	 * return o.getage-age;
	 * */
	public int compareTo(person o) {
		return -1;
	}
	
}
public class learn{
	public static void main(String[] args) {
		TreeSet<person> hs=new TreeSet<>();
		hs.add(new person("张三",21));
		hs.add(new person("李四",22));
		hs.add(new person("王五",23));
		System.out.println(hs);   //[[姓名：张三 年龄：21], [姓名：李四 年龄：22], [姓名：王五 年龄：23]]

	}
}
