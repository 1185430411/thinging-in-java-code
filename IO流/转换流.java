package JAY01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class IOTesr {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*try (
				BufferedReader br=new BufferedReader(new FileReader("jay.txt"));
				BufferedWriter bw=new BufferedWriter(new FileWriter("good.txt"));
				)
		{		
			String msg;
			while((msg=br.readLine())!=null) {
				bw.write(msg);
			} 
			//出现乱码，因为jay.txt是utf-8格式。good.txt默认是gbk格式
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		//使用交换流
		//可以正常执行
		try(
				//InputStreamReader isr=new InputStreamReader(new FileInputStream("jay.txt"),"utf-8");  //传入一个字节流，和一个字符串
				//OutputStreamWriter osr=new OutputStreamWriter(new FileOutputStream("good.txt"),"gbk");
				BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("jay.txt"),"utf-8"));  //缓冲流装饰
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("good.txt"),"gbk"));

				){
			String msg;
			while((msg=br.readLine())!=null) {
				bw.write(msg);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
