package com.lh.web;
//修改信息
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.model.Fruit;
import com.lh.utils.JDBCUtils;


public class FruitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Fruit fruit=findFruitById(id);
		
		request.setAttribute("fruit", fruit);
		request.getRequestDispatcher("/WEB-INF/JSP/fruitupdata.jsp")
		.forward(request, response);
		
	}
	
	private Fruit findFruitById(int id){
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from fruit where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			Fruit fruit=null;
			if(rs.next()){
				fruit=new Fruit();
				fruit.setId(rs.getInt("id"));
				fruit.setName(rs.getString("name"));
				fruit.setPrice(rs.getDouble("price"));
				fruit.setNum(rs.getInt("num"));
			}
			return fruit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询失败！");
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		return null;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}