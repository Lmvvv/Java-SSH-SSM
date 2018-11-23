package com.lh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lh.utils.JDBCUtils;

public class UserUpdataDao {

	public void updById(int id, String username,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "update user set username=?,password=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("信息修改失败!");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}
}
