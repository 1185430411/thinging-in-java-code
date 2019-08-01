package JAY01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class IOTesr {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try(FileOutputStream fos=new FileOutputStream("jay.txt");){
			String msg="好好学习";
			fos.write(msg.getBytes(),0,3);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//jay.txt内容变为:好�   之间写的一直是英文。现在写中文出现乱码。因为一个中文占两个字节，而自定义byte数组一次
		//传输3个字节，故会出现乱码。其实一个方法就是不使用自定义byte数组，直接让msg.getBytes()作为传入参数
	}
}
