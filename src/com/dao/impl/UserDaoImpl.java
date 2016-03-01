package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.User;
import com.conectionUtil.JdbcConnection;
import com.dao.UserDao;

public class UserDaoImpl implements UserDao{

	private static Connection con = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	@Override
	public boolean register(User user) {
		int sql_flag = 0;
		con = JdbcConnection.getConnection();
		String sql = "insert into sd_user(user_name,user_password,user_email)values(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_password());
			pstmt.setString(3, user.getUser_email());
			sql_flag = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.closeAll(rs, pstmt, con);
		}
		if(sql_flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean login(User user) {
		boolean sql_flag = false;
		con = JdbcConnection.getConnection();
		String sql = "select * from sd_user where user_email= ? and user_password = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUser_email());
			pstmt.setString(2, user.getUser_password());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sql_flag = true;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.closeAll(rs, pstmt, con);
		}
		
		return sql_flag;
	}

}
