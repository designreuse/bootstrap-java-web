package com.conectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	private static java.sql.Connection con = null;
	/**
	 * Mysql 连接
	 */
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URLSTR = "jdbc:mysql://localhost:3306/project";
	private static final String USERNAME = "root";
	private static final String USERPASSWORD = "root";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(URLSTR, USERNAME, USERPASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeAll(ResultSet set, PreparedStatement psta, Connection con) {
		if(set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(psta != null) {
			try {
				psta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
