package com.jay.cookie;

import java.util.HashMap;
import java.util.Map;

public class chushihua {
	private static Map<String,book> books=new HashMap<String,book>();
	static {
		books.put("1",new book("1","java入门",20,"马化腾"));
		books.put("2",new book("2","c++入门",30,"李彦宏"));
		books.put("3",new book("3","python入门",20,"雷军"));
		books.put("4",new book("4","php入门",50,"马云"));
	}
	
	public static Map<String,book> findallbook(){
		return books;
	}
	
	public static book findbookbyid(String id) {
		return books.get(id);
	}
}
