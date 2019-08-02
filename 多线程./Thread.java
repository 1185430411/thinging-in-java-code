package JAY01;


/**
 * 
 * @author 11854
 *使用Thread来创建多线程方法：
 *1.继承Thread类
 *2.重写run方法
 *3.在run方法里编写线程要执行的内容
 *34.调用start函数进行开启线程
 */
class myThread extends Thread{
	public void run() {
		for(int i=0;i<200;i++) {
			System.out.print("jay");
		}
	}
}

public class IOTesr {
	public static void main(String[] args) {
		myThread mt=new myThread();
		mt.start();
		
		for(int i=0;i<200;i++) {
			System.out.print("main");
		}  
		
		//结果:main和jay连续且交替打印。每次运行结果都不一样  如：mainmainmainjayjaymainjayjay
	}
}
