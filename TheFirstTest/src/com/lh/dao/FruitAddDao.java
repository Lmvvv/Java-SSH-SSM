package com.lh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lh.utils.JDBCUtils;

public class FruitAddDao {

	public void addFruit(String name, double price, int num) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "insert into fruit values(null, ?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setInt(3, num);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}
}
