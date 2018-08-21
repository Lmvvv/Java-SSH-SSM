package com.lh.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lh.utils.JDBCUtils;

public class LoginServlet1 extends HttpServlet {
	private boolean f=false;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//创建一个session
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		System.out.println(username+password);
		String jsessionID=session.getId();
		//session持久化
		Cookie cookie=new Cookie("JSESSIONID", jsessionID);
		cookie.setPath("/TheFirstTest/");
		cookie.setMaxAge(60*5);
		response.addCookie(cookie);

		if(login(username, password)){
			request.getRequestDispatcher("/JSP/management.jsp").forward(request, response);
		}else {
			
		}
	}
	
	private boolean login(String username,String password){
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
		}finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return f;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}