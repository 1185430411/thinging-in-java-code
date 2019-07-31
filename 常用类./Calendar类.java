package learn;

import java.util.Calendar;

/*
 * */
public class learn{
	public static void main(String[] args) {
		//Calendar c=new Calendar();  Calendar是一个abstract类，无法通过new来构造
		Calendar c=Calendar.getInstance();   //用方法进行构造
		int a=c.get(Calendar.DAY_OF_WEEK);  //获取今天是这个星期的第几天。从星期天开始算作第一天
		System.out.println(a);//2
		
		int b=c.get(Calendar.DAY_OF_YEAR);  //获取今天是今年的第一天。今天是7.31，是第212天
		System.out.println(b); //212
	}
}
