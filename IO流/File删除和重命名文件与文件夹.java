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
		File f1=new File("D://jay.txt");
		File f2=new File("D://jay");
		File f3=new File("D://old.txt");
		File newname=new File("D://jayice.txt");
		try {
			System.out.println(f1.createNewFile());  //true
			System.out.println(f2.mkdir());   //true
			System.out.println(f3.createNewFile());  //true
			f1.delete();   //D盘中的jay.txt被删除了
			
			f3.renameTo(newname);    //D盘中的old.txt重命名成了jayice.txt    若newname和f3不在一个目录下，则会把f3移到目标目录，再重命名
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
