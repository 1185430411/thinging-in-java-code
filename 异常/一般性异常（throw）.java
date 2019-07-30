/*一般性异常指在编译时就无法通过，需要进行处理的异常
除了RunTimeException，其他都是一般性异常
*/


package learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class learn {
	public static void main(String[] args) throws FileNotFoundException {
		m1();
	}
  /*每次调用都要对异常进行处理*/
	public static void m1() throws FileNotFoundException {
		m2();
	}
	public static void m2() throws FileNotFoundException {
		m3();
	}
	public static void m3() throws FileNotFoundException {
		FileInputStream fis=new FileInputStream("d:/jayice.txt");
	}
}
