package com.lh.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.dao.User_FruitListDao;
import com.lh.model.User_Fruit;

public class User_FruitListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User_FruitListDao ufdao=new User_FruitListDao();
		List<User_Fruit> uflist=new ArrayList<User_Fruit>();
		uflist=ufdao.findUser_Fruit();
		request.setAttribute("uflist", uflist);
		request.getRequestDispatcher("/WEB-INF/JSP/UserAndFruit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}