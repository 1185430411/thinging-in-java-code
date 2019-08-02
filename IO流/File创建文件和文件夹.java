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
		File f1=new File("D://jay.txt");   //再D盘下创造一个jay.txt文件
		
		File f2=new File("D://10241");
		
		File f3=new File("D://666//111");
		try {
			System.out.println(f1.createNewFile());//建立成功返回true。如果已经有这个文件，创建失败，返回false
			System.out.println(f2.mkdir());         //同样返回布尔值，但这个是创建文件夹
			System.out.println(f3.mkdirs());        //同样返回布尔值，但这个可以创建多个文件夹
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
