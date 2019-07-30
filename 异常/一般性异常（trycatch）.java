/*throw方法其实并没有解决异常，而是将异常抛给JVM处理。
而try catch则是捕获了异常
*/


package learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class learn {
	public static void main(String[] args)  {
		try {
		FileInputStream fis=new FileInputStream("d:/jayice.txt");
		fis.read();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			String s=e.getMessage();
			System.out.print(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    /*能够正常输出*/
		System.out.print("catch 后面");
	}
	
}

/*
result：
java.io.FileNotFoundException: d:\jayice.txt (系统找不到指定的文件。)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(Unknown Source)
	at java.io.FileInputStream.<init>(Unknown Source)
	at java.io.FileInputStream.<init>(Unknown Source)
	at learn.learn.main(learn.java:10)
d:\jayice.txt (系统找不到指定的文件。)
catch 后面
*/
