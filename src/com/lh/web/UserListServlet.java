package com.lh.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.dao.UserDao;
import com.lh.model.User;

public class UserListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userdao = new UserDao();
		List<User> userlist = new ArrayList<User>();
		userlist = userdao.findUser();
		request.setAttribute("userlist", userlist);
		request.getRequestDispatcher("/WEB-INF/JSP/userlist.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}