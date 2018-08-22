package com.lh.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lh.utils.JDBCUtils;

public class FruitDao {

	private int pageSize=5;//每页显示10个数据
	
	//求总页数
	public int getPage(){
		int totalNum=0;
		int totalPage=0,remainder=0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn=JDBCUtils.getConn();
			String sql="select count(*) from fruit";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			rs.next();
			totalNum=rs.getInt(1);
			totalPage=totalNum/pageSize;
			remainder=totalNum%pageSize;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		if(remainder!=0){
			totalPage++;
		}
		return totalPage;
	}
	
	//某一页的数据
	public List<Fruit> listFruit(int pageNo){
		int page=(pageNo-1)*pageSize;
		List<Fruit> fylist=new ArrayList<Fruit>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from fruit order by id limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			Fruit fruit=null;
			while(rs.next()){
				fruit=new Fruit();
				fruit.setId(rs.getInt("id"));
				fruit.setName(rs.getString("name"));
				fruit.setPrice(rs.getDouble("price"));
				fruit.setNum(rs.getInt("num"));
				fylist.add(fruit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		return fylist;
	}
}
