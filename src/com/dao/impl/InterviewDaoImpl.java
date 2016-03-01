package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.beans.Interview;
import com.conectionUtil.JdbcConnection;
import com.dao.InterviewDao;

public class InterviewDaoImpl implements InterviewDao{

	private static Connection con = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private List<Interview> list = null;
	
	@Override
	public boolean createInterview(Interview interview) {
		int sql_flag = 0;
		String sql = "insert into sd_interview(interview_title,interview_desc,interview_time,interview_user,interview_place,interview_phone)values(?,?,?,?,?,?)";
		
		try {
			Date date = new Date();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, interview.getInterview_title());
			pstmt.setString(2, interview.getInterview_desc());
			pstmt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
			pstmt.setString(4, interview.getInterview_user());
			pstmt.setString(5, interview.getInterview_place());
			pstmt.setString(6, interview.getInterview_phone());
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

	public boolean updateInterview(Interview interview) {
		boolean sql_flag = false;
		String sql = "update sd_interview set interview_title = ?,interview_desc = ?,interview_user = ?,interview_place = ?,interview_phone = ? where interview_id = ?";
		con = JdbcConnection.getConnection();
		System.out.println(interview.getInterview_desc());
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, interview.getInterview_title());
			pstmt.setString(2, interview.getInterview_desc());
			pstmt.setString(3, interview.getInterview_user());
			pstmt.setString(4, interview.getInterview_place());
			pstmt.setString(5, interview.getInterview_phone());
			pstmt.setInt(6, interview.getInterview_id());
			if(pstmt.executeUpdate() > 0) {
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
	
	public boolean deleteInterview(Interview interview) {
		boolean sql_flag = false;
		String sql = "delete from sd_interview where interview_id = ?";
		con = JdbcConnection.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, interview.getInterview_id());
			if(pstmt.executeUpdate(sql) > 0) {
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
	
	@Override
	public List<Interview> findInterview(Interview interview, boolean condition) {
		
		boolean sql_flag = false;
		boolean sql_sp = false;
		
		con = JdbcConnection.getConnection();
		String sql = "select * from sd_interview";
		if(condition) {
			sql += " where";
			if(interview.getInterview_id() != -1) {
				sql += " interview_id = ";
				sql = sql + interview.getInterview_id();
				sql_sp = true;
			}
			if(interview.getInterview_title() != null) {
				if(sql_sp) {
					sql += " and";
				}
				sql += " interview_title like ";
				sql = sql + "'%" + interview.getInterview_title() + "%'";
				sql_sp = true;
			}
			if(interview.getInterview_place() != null) {
				if(sql_sp) {
					sql += " and";
				}
				sql += " interview_user like ";
				sql = sql + "'%" + interview.getInterview_user() + "%'";
				sql_sp = true;
			}
			if(interview.getInterview_place() != null) {
				if(sql_sp) {
					sql += " and";
				}
				sql += " interview_place like ";
				sql = sql + "'%" + interview.getInterview_place() + "%'";
				sql_sp = true;
			}
			if(interview.getInterview_phone() != null) {
				if(sql_sp) {
					sql += " and";
				}
				sql += " interview_phone like ";
				sql = sql + "'%" + interview.getInterview_phone() +"%'";
			}
		}
		System.out.println(sql);
		try {
			list = new ArrayList<Interview>();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Interview intf = new Interview();
				intf.setInterview_id(rs.getInt("interview_id"));
				intf.setInterview_title(rs.getString("interview_title"));
				intf.setInterview_desc(rs.getString("interview_desc"));
				intf.setInterview_user(rs.getString("interview_user"));
				intf.setInterview_time(rs.getTimestamp("interview_time"));
				intf.setInterview_place(rs.getString("interview_place"));
				intf.setInterview_phone(rs.getString("interview_phone"));
				list.add(intf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcConnection.closeAll(rs, pstmt, con);
		}
		
		return list;
	}

}
