package com.lh.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.dao.UserAddDao;

public class UserAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserAddDao useradddao=new UserAddDao();
		useradddao.addUser(username, password);
		
		response.setHeader("Refresh", "1;url=" + request.getContextPath() + "/UserListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}