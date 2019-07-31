package learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * */
public class learn{
	public static void main(String[] args) throws ParseException {
		Date d=new Date();
		System.out.println(d);   //Wed Jul 31 14:09:21 CST 2019
		
		Date d1=new Date(0);
		System.out.println(d1);  //Thu Jan 01 08:00:00 CST 1970
		
		SimpleDateFormat sfd=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
		//把Date转化为特定格式来输出
		String s=sfd.format(d);
		System.out.println(s);  //2019年07月31日 02:09:21
		
		
		
		//把String转化为Date
		//作用就是当需要把String类的日期格式转化为另一种格式来输出，则利用Date作为中转
		String s1="2000-06-07 20:00:00";
		SimpleDateFormat sfd1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d2=sfd1.parse(s1);  //需要抛出异常
		System.out.println(d2);  //Wed Jun 07 20:00:00 CST 2000
	}
}
