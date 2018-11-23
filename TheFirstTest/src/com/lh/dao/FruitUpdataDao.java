package com.lh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lh.utils.JDBCUtils;

public class FruitUpdataDao {

	public void updataById(int id, String name, double price, int num){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "update fruit set name=?,price=?," + "num=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setInt(3, num);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}
}
