package learn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * vector集合被用得很少
 * 了解即可
 * */
public class learn{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		List<Integer> lis=new ArrayList<>();
		lis.add(1);
		lis.add(2);
		lis.add("a");   //Exception
		
		@SuppressWarnings("rawtypes")
		List lis1=new ArrayList();
		lis1.add(1);
		lis1.add("a");  //OK
	}
}
