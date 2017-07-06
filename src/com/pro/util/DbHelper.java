package com.pro.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper {

	public static Connection getConn()throws Exception{
		Connection conn=null;
		
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/t3","root","root");
		
		return conn;
	}
	
	public static void close(Connection conn)throws Exception{
		if(conn!=null){
			conn.close();
		}
		
	}
}
