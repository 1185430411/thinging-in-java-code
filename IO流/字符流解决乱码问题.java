package JAY01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
		FileReader fr=new FileReader("jay.txt");
		FileWriter fw=new FileWriter("good.txt");
				)
		{
			int temp;
			while((temp=fr.read())!=-1) {
				fw.write((char)temp);
				System.out.print((char)temp);   //好好学习天天向上
			}
			fw.flush();   //好好学习天天向上
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
