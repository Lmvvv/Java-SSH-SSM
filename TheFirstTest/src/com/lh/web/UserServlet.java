package com.lh.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.dao.FindUserByIdDao;
import com.lh.model.User;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		FindUserByIdDao fubd=new FindUserByIdDao();
		User user=null;
		try {
			user = fubd.findUserById(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/JSP/userupdata.jsp")
			.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}