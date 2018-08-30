package com.lh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lh.model.User;
import com.lh.utils.JDBCUtils;

public class UserDao extends BaseDao {
	
	public User findUser1() throws SQLException{
		String sql="select * from user";
		List<String> conds = new ArrayList<String>();
		ResultSet rs=getJDBCData(sql, conds.toArray(new String[]{}));
		User user=null;
		while(rs.next()){
			user=new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
		}
		closeResultSet();
		return user;
	}
	

	public List<User> findUser(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from user";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			List<User> list=new ArrayList<User>();
			User user=null;
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("用户查询失败!");
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		return null;
	}
}
