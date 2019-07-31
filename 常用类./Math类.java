package learn;


/*
 * */
public class learn{
	public static void main(String[] args) {
		System.out.println(Math.PI);   //3.141592653589793
		
		//绝对值
		System.out.println(Math.abs(-100));  //100
		
		//向上取整
		System.out.println(Math.ceil(12.4));  //13.0
		System.out.println(Math.ceil(12.9));  //13.0
		
		//向下取整
		System.out.println(Math.floor(12.4));  //12.0
		System.out.println(Math.floor(12.9));  //12.0
		
		
		//四舍五入
		System.out.println(Math.round(12.4));  //12
		System.out.println(Math.round(12.9));  //13
		
		
		//随机数 0.0到1.0之间。包括0，0 不包括1.0
		System.out.println(Math.random());    //0.18565912481675106
		
		//开方
		System.out.println(Math.sqrt(16));  //4.0
		
		//次方运算
		System.out.println(Math.pow(3, 2));  //9.0
		
	}
}
