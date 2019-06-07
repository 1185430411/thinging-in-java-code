//对内部类的继承


package Ten10;
class out{
	class in{
		
	}
}

public class extendsinner extends out.in{
	public extendsinner(out o) {                    //固定格式：构造器传入外围对象，并对外围对线使用super方法
		o.super();
		System.out.println("构造成功");
	}
	public static void main(String[] args) {
		extendsinner e=new extendsinner(new out());
	}
}


/*
测试用例：
构造成功
*/
