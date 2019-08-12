package com.jay.pool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

public class usePool2 {
	public static void main(String[] args) {
		DataSource pool=new pool2();
		Connection conn=null;
		try {
			conn=pool.getConnection();  //获得myConnection的对象
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement("......");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}try {
            //该关就关闭,该回收就回收。是否真的关闭，取决于使用的是哪个conn对象
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
