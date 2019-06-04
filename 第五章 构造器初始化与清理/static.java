package thinkinginjava;


class cup{
	cup(int i){
		System.out.println(i);
	}
}


class cup2{
	static cup a=new cup(1);        //在cup2里，第一步先执行
	cup2(){                         //第三步执行
		System.out.println("cup2的构造器");
	}
	static cup3 f=new cup3();       //第二步执行
}

class cup3{
	static cup b=new cup(2);
	cup3(){
		System.out.println("cup3的构造器");
	}
}
public class usestaic {
	public static void main(String[] args) {
		System.out.println("main里面");
		new cup2();
	}
	static cup2 c=new cup2();             //先执行静态变量，再执行main里面的。且因为静态量只能被初始化一次，所以main函数里面构造cup2，不会再调用cup的构造器

}

/*
测试结果：
1
2
cup3的构造器
cup2的构造器
main里面
cup2的构造器
*/





package thinkinginjava;


class cup{
	cup(int i){
		System.out.println(i);
	}
}


class cup2{
	cup a=new cup(1);   //和上面用例不同的是，去掉了static，则可以被多次初始化，main里也会调用cup类的构造器
	cup2(){
		System.out.println("cup2的构造器");
	}
	static cup3 f=new cup3();
}

class cup3{
	static cup b=new cup(2);
	cup3(){
		System.out.println("cup3的构造器");
	}
}
public class usestaic {
	public static void main(String[] args) {
		System.out.println("main里面");
		new cup2();
	}
	static cup2 c=new cup2();             //先执行这里，再执行main里面的。且因为静态量只能被初始化一次，所以main函数里面构造cup2，不会再调用cup的构造器

}

/*
2
cup3的构造器
1
cup2的构造器
main里面
1
cup2的构造器
*/
