package com.lh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lh.model.User_Fruit;
import com.lh.utils.JDBCUtils;

public class User_FruitListDao {

	public List<User_Fruit> findUser_Fruit(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from user_fruit";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			List<User_Fruit> list=new ArrayList<User_Fruit>();
			User_Fruit user_fruit=null;
			while(rs.next()){
				user_fruit=new User_Fruit();
				user_fruit.setId(rs.getInt("id"));
				user_fruit.setUserid(rs.getInt("userid"));
				user_fruit.setFruitid(rs.getInt("fruitid"));
				list.add(user_fruit);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询失败!");
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		return null;
	}
}
