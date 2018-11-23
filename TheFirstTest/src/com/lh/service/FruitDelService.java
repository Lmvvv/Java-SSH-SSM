package com.lh.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lh.dao.FruitDelDao;
import com.lh.utils.JDBCUtils;

public class FruitDelService {

	public boolean fruitdel(int id){
		FruitDelDao fdd=new FruitDelDao();
		boolean isDelSuccess=true;
		Connection conn=null;
		
		try {
			conn=JDBCUtils.getConn();
			conn.setAutoCommit(false);
			fdd.delFruit(id);
			fdd.delUser_fruit(id);
			conn.commit();
		} catch (Exception e) {
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
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					conn=null;
				}
			}
		}
		return isDelSuccess;
	}
}
