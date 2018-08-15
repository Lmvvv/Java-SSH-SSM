package com.lh.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.utils.JDBCUtils;;

public class FruitUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int num = Integer.parseInt(request.getParameter("num"));

		updById(id, name, price, num);
		response.getWriter().write("修改成功");
		response.setHeader("Refresh", "1;url=" + request.getContextPath() + "/FruitListServlet");
	}

	private void updById(int id, String name, double price, int num) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "update fruit set name=?,price=?," + "num=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setInt(3, num);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("信息修改失败!");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}