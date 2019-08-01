package JAY01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
*需要使用较多的trycatch，但都是自动生成的
*/
public class IOTesr {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("D:\\jay.txt");
			int temp=0;
			byte[] b=new byte[4];
			
			try {
				//方法1：逐个字节进行读
				/*while((temp=fis.read())!=-1) {
					System.out.print((char)temp);   //JAYICE
				}*/
				
				//
				while((temp=fis.read(b))!=-1) {
					System.out.println(temp+" ");  //4 2    第一次读4个，第二次读2个两次
					System.out.println(new String(b));  //JAYI  CEYI  //最后两个覆盖了前两个
					System.out.println(new String(b,0,temp)); //JAYI CE  //从0开始读，读temp个
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
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
