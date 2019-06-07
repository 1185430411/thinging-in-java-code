package Ten10;

interface service{
	Object print();
	boolean end();
	void next();
}

class vector{
	private Object[] obj;
	private int next;
	public vector(int size) {
		obj=new Object[size];
	}
	public void make(Object x) {
		obj[next++]=x;
	}
	
  
	class operate implements service{
		private int i=0;
		public Object print() {
			return obj[i];                 //可以直接使用大类的obj
		}
		public void next() {
			if(i<obj.length) i++;
		}
		public boolean end() {
			if(i<obj.length)return true;
			else return false;
		}
	}
	
	public service back() {
		return new operate();
	}
}

public class innerright {
	public static void main(String[] args) {
		vector v=new vector(10);
		for(int i=0;i<10;i++) v.make(i);
		@SuppressWarnings("unused")
		service o=v.back();
		while(o.end()) {
			System.out.println(o.print());
			o.next();
		}
	}
}


/*
测试结果：
0
1
2
3
4
5
6
7
8
9
*/







