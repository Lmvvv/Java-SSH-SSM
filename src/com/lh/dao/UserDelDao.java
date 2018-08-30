package com.lh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lh.utils.JDBCUtils;

public class UserDelDao {
	
	public void delUser(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "delete from user where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);;
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}
	
	public void delUser_fruit(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "delete from user_fruit where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);;
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}
}
