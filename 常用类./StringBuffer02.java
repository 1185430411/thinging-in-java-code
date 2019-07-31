package learn;

/*
 *使用StringBuffer进行字符串拼接 
 * */
public class learn{
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		sb.append("www.");
		sb.append("jayice666");
		sb.append(".com");
		System.out.println(sb);     //www.jayice666.com
		System.out.println(sb.capacity());   //32
		
		sb.insert(4, "666");
		System.out.println(sb);  //www.666jayice666.com
		
		sb.delete(4, 7);  //去头不去尾
		System.out.println(sb);  //www.jayice666.com
		
	}
}
