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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class IOTesr {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try(
				BufferedReader br=new BufferedReader(new FileReader("jay.txt"));
				BufferedWriter bw=new BufferedWriter(new FileWriter("w.txt"));
				)
		{
			String msg;
			while((msg=br.readLine())!=null) {
				bw.write(msg);
				bw.newLine();   //换行
				System.out.print(msg);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
