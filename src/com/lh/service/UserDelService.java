package com.lh.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lh.dao.UserDelDao;
import com.lh.utils.JDBCUtils;

public class UserDelService {

	public boolean userdel(int id){
		UserDelDao udd=new UserDelDao();
		boolean isDelSuccess=true;
		
		Connection conn=null;
		try {
			conn=JDBCUtils.getConn();
			conn.setAutoCommit(false);
			udd.delUser(id);
			udd.delUser_fruit(id);
			conn.commit();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			isDelSuccess=false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
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
		return isDelSuccess;
		
	}
}
