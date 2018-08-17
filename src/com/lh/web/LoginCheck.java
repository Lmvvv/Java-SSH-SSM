package com.lh.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lh.utils.JDBCUtils;

public class LoginCheck {
	private String username;
	private String password;
	private boolean f=false;
	public LoginCheck(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public boolean login(String username,String password){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn=JDBCUtils.getConn();
			String sql="select username,password from user where username='"+username+"'"+"and password='"+password+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			if(rs.next()){
				f=true;
				return f;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

}
