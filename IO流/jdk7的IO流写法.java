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
		/*
		 * jdk7新写法。在try后面添加一个小括号，在括号里进行IO通道的打开。这样就不用中finally里面将通道关闭
		 * */
		try(
				FileInputStream fis=new FileInputStream("jay.txt");
				FileOutputStream fos=new FileOutputStream("good1.txt");
				){
			byte[] b=new byte[8];
			int temp;
			while((temp=fis.read(b))!=-1) {
				fos.write(b,0,temp);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
