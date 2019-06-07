//static的内部类，与外部类无关联，不能使用外部类的参数

package Ten10;
class vector{
	private int[] a;
	private int n=0;
	public void create(int size) {
		a=new int[size];
	}
	public void give(int i) {
		a[n++]=i;
	}
	
	static class operate{
		private int n;
		public void test() {
			if(n<a.length) System.out.println("ook");           //error:
		}
	}
}
