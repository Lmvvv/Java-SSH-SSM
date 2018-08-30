package com.lh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lh.utils.JDBCUtils;

public class UserAddDao {

	public void addUser(String username,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "insert into user values(null, ?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}
}
