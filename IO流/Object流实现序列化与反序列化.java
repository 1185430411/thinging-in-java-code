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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/*
*序列化与反序列化就是对象和文件之间的转换
*有助于开发过程中把对象进行远程传输
*/
class student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	 public void setname(String name) {
		 this.name=name;
	 }
	 public String getname() {
		 return name;
	 }
}

public class IOTesr {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		student zhangsan=new student();
		zhangsan.setname("张三");
		  //序列化:将对象变为文件
		try(
				/**/
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D://xulie"));
		) {
			oos.writeObject(zhangsan);  //于是张三这个对象就被写到文件中了
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//反序列化：将文件变回为序列
		try(
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D://xulie"));
		){
			student s=(student)ois.readObject();
			
			System.out.println(s.getname());   //张三
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
