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
		
//		Cookie cookieusername=new Cookie("cookieusername", username);
//		Cookie cookiepassword=new Cookie("cookiepassword", password);
//		cookieusername.setMaxAge(60*10);
//		cookiepassword.setMaxAge(60*10);
//		cookieusername.setPath("/TheFirstTest/");
//		cookiepassword.setPath("/TheFirstTest/");
//		response.addCookie(cookieusername);
//		response.addCookie(cookiepassword);
		//创建一个session
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		String jsessionID=session.getId();
		//session持久化
		Cookie cookie=new Cookie("JSESSIONID", jsessionID);
		cookie.setPath("/TheFirstTest/");
		cookie.setMaxAge(60*5);
		response.addCookie(cookie);

//		if(login(username, password)){
//			request.getRequestDispatcher("/WEB-INF/JSP/management.jsp").forward(request, response);
//		}else {
//			request.getRequestDispatcher("/WEB-INF/JSP/fruitlist.jsp").forward(request, response);
//		}
		if(login(username, password)){
			if(username.equals("admin")){
				request.getRequestDispatcher("/WEB-INF/JSP/management.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/WEB-INF/JSP/user.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
		}
	}
	
	private boolean login(String username,String password){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from user where username=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
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