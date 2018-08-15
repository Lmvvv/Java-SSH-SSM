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

import com.lh.utils.*;

public class FruitDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		delFruit(id);
		response.getWriter().write("<h1 style='color:red;text-align:center'>"+
									"删除成功"+
									"</h1>");
		//定时刷新，视频14-03
		response.setHeader("Refresh", "2;url=" + request.getContextPath() +"/FruitListServlet");
	}
	
	private void delFruit(int id){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "delete from fruit where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);;
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}