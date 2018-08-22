package com.lh.web;

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
import javax.servlet.http.HttpSession;

import com.lh.utils.JDBCUtils;

public class FruitListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		List<Fruit> list=findFruit();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/JSP/fruitlist.jsp").forward(request, response);
	
	}
	
	private List<Fruit> findFruit(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from fruit";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			List<Fruit> list=new ArrayList<Fruit>();
			Fruit fruit=null;
			while(rs.next()){
				fruit=new Fruit();
				fruit.setId(rs.getInt("id"));
				fruit.setName(rs.getString("name"));
				fruit.setPrice(rs.getDouble("price"));
				fruit.setNum(rs.getInt("num"));
				list.add(fruit);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("商品查询失败!");
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		return null;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}