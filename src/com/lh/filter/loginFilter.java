package com.lh.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lh.utils.JDBCUtils;

/**
 * Servlet Filter implementation class loginFilter
 */
public class loginFilter implements Filter {
	private boolean f = false;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 判断用户是否已经登陆过了
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		System.out.println("loginFilter "+"username=" + username + " password=" + password);

		// 如果用户已经登陆过了，则直接进入到管理页面
		if (login(username, password)) {
			 response.getWriter().write("<h1 style='text-align:center'>");
			 response.getWriter().write("您已经登陆过了，可以跳过登录页面..");
			 response.getWriter().write("</h1>");
			 res.setHeader("Refresh", "2;url="+ req.getContextPath()
			 +"/CheckedServlet");
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	private boolean login(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "select username,password from user where username='" + username + "'" + "and password='"
					+ password + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			if (rs.next()) {
				f = true;
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

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
