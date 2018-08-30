package com.lh.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lh.model.User;

public class FindUserByIdDao extends BaseDao {

	public User findUserById(int id) throws Exception {
		String sql = "select * from user where id=?";

		List<String> conds = new ArrayList<String>();
		conds.add(String.valueOf(id));
		ResultSet rs = getJDBCData(sql, conds.toArray(new String[]{}));

		User user = null;
		if (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
		}
		closeResultSet();
		return user;
	}
}
