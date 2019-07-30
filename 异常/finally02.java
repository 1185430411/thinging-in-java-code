package learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class learn {
	public static void main(String[] args)  {
		System.out.println(m1());
	}
	
	public static int m1() {
		int i=10;
		try {
			return i   //实际上是：int temp=i;return temp; 所以后续对i的操作与返回值无关
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}finally {
			i++;
			System.out.println("finally里面的i是："+i);
		}
		//System.out.print(i);
		return i;
	}
}


/*
result:
finally里面的i是：11
10

*/
