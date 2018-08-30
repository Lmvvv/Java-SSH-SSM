package com.lh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lh.utils.JDBCUtils;

public class BaseDao {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	public ResultSet getJDBCData(String sql, String... conds) {

		try {
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < conds.length; i++) {
				ps.setString(i + 1, conds[i]);
			}
			return ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			return rs;
		}

	}

	public void closeResultSet() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ps = null;
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

}
