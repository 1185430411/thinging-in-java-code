/*
finally中的语句一定会被执行
*/

package learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class learn {
	public static void main(String[] args)  {
		System.out.println(m1());
	}
	
	public static int m1() {
		try {
			int i=10;
			return i;
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally里面");
		}
		//System.out.print(i); try里面的变量只能在try里面被访问
		return 1;  //在try外面还需进行return。
	}
}


/*
result：
finally里面
10

*/
