package com.jay.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * 模拟编写一个数据库连接池
 * 初始化一个数据库连接池并向里面添加10个数据库连接
     从连接池中获取连接
     当程序用完连接后，需要将该连接重新放入到连接池中
 * */
public class test {
	// 因为数据库连接池需要对Connection进行频繁插入移除，所以选择LinkedList
	// 再调用Collection的synchronizedList来解决线程安全问题
	private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections
			.synchronizedList(new LinkedList<Connection>());
	static {

		try {
			for (int i = 0; i < 10; i++) {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/plane", "root", "123");
				pool.add(conn);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	//从数据库连接池中获取连接
	public static Connection getConnection() {
		Connection conn=null;
		
		//判断数据库连接池中是否有Connction对象
		if(pool.size()>0) {
			conn=pool.removeFirst();
		}else{
			throw new RuntimeException("服务器忙，请稍后再试");
		}
		return conn;
	}
	
	
	//当程序用完连接后，需要将该连接重新放入到连接池中
	
	public static void release(Connection conn) {
		pool.add(conn);
	}
}
