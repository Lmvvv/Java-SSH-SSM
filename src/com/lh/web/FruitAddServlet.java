package com.lh.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lh.utils.*;

public class FruitAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int num = Integer.parseInt(request.getParameter("num"));
			
		addFruit(name, price, num);	
		response.getWriter().write("商品添加成功");
		response.setHeader("Refresh", "1;url=" + request.getContextPath() + "/FruitListServlet");
	}

	private void addFruit(String name, double price, int num) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "insert into fruit values(null, ?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setInt(3, num);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}