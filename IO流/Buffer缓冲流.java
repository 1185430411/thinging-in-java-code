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
		//Buffered缓冲流。传入一个File流的对象，可以理解为进行了一个封装。Buffered源码中也自动创建了一个byte数组来
		//提高写的效率，不用自己额外写一个byte数组来提高效率
		BufferedOutputStream bos=null;
		BufferedInputStream bis=null;
		try {
			bos=new BufferedOutputStream(new FileOutputStream("good.txt"));   //Buffered缓冲流
			bis=new BufferedInputStream(new FileInputStream("jay.txt"));
			int temp;
			try {
				while((temp=bis.read())!=-1) {
					bos.write(temp);
				}
				bos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
