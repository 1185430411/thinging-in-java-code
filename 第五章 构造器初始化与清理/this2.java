package thinkinginjava;

public class usethis {
	usethis(){
		this(4,"haha");
	}
	
	usethis(int i){
		
		System.out.println(i);
	}
	
	usethis(String ss){
		System.out.println(ss);
	}
	  usethis(int i,String ss){
		 this(i);   //用i作为形式参数，调用usethis（int i）构造器
		 // this(ss);  error 只能使用一个this
		 System.out.println(ss+i);
	 }
	 
	 public static void main(String []args) {
		 usethis a=new usethis();
	 }
}

/*
测试结果：
4
haha4
*/
