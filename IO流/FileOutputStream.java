package JAY01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTesr {
	public static void main(String[] args) {
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("D://jay.txt",true);  //再原有内容上进行write
			// fos=new FileOutputStream("D://jay.txt");  这个只有一个参数的方法，会直接把文件中的所有内容都进行清空，再执行下面的write操作
			String msg="Hello World";
			try {
				fos.write(msg.getBytes());
				fos.write("\n".getBytes());
				fos.write("JAY".getBytes());
				//刷新一下文件
				fos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
