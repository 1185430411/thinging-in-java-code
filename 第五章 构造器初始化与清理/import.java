package test;

public class testprint {
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void print(int i) {
		System.out.println(i);
	}
}


package thinkinginjava;
import test.testprint;

public class useimport {
	public static void main(String[] args) {
		testprint.print("Hello World");
	}
}


/*
测试结果：
Hello World
*/
