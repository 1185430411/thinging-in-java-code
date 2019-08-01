package JAY01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
*把原有的jay.txt文件拷贝到一个新的文件good.txt中
*/
public class IOTesr {
	public static void main(String[] args) {
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try {
			fos=new FileOutputStream("good.txt");
			fis=new FileInputStream("jay.txt");
			byte[] b=new byte[6];
			int temp;
			try {
				while((temp=fis.read(b))!=-1) {    //每次以6字节对jay.txt进行读
					fos.write(b,0,temp);             //每次对good.txt，利用b进行从0到temp的写
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();   //关闭IO通道
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
