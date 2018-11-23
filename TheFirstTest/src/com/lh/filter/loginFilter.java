package com.lh.filter;

import java.io.IOException;
import java.io.PrintWriter;
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
	
		chain.doFilter(request, response);
	}

	private boolean login(String username, String password) {
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
		} finally {
			JDBCUtils.close(conn, ps, rs);
			
		}
		return f;
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
