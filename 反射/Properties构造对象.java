package JAY01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Test {
	/*
	 * properties的格式为：  Key=Values
	 * 如果把Value写成类的java地址，那么就不需要每次都要构造类。
	 * 只需要调用Properties就可以
	 * */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Properties p = new Properties();
		try (FileReader fr = new FileReader("jay.properties");) {
			p.load(fr);  //把文件读到Properties中
			System.out.println(p.getProperty("day1"));  //JAY01.audi
			Class c=Class.forName(p.getProperty("day1"));  //构建class文件
			Object o=c.newInstance();  //奥迪

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
