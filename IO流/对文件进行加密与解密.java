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
		//加密
		try(
				FileOutputStream fos=new FileOutputStream("code.txt");
				FileInputStream fis=new FileInputStream("jay.txt");
				){
			int temp;
			while((temp=fis.read())!=-1) {
				fos.write(temp^66);
			}
			fos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//code.txt内容为：'..-b-0.&m,  内容被加密
		
		
		//解密
		try(
				FileOutputStream fos=new FileOutputStream("decode.txt");
				FileInputStream fis=new FileInputStream("code.txt");
				){
			int temp;
			while((temp=fis.read())!=-1) {
				fos.write(temp^66);
			}
			fos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//decode.txt的内容为:Hello World/nJAY  一个数字对同一个数字进行两次异或操作，结果得到它本身
	}
}
