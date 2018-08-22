package com.lh.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FruitListFY extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int pageNo = 1;
		FruitDao fruitdao = new FruitDao();
		List<Fruit> fylist = new ArrayList<Fruit>();

		String pageno = request.getParameter("pageNo");
		if (pageno != null) {
			pageNo = Integer.valueOf(pageno);
		}
		fylist = fruitdao.listFruit(pageNo);
		int totalPage = fruitdao.getPage();
//		if (pageNo < 1) {
//			pageNo = 0;
//		} else if (pageNo > totalPage) {
//			pageNo = totalPage + 1;
//		}
		request.setAttribute("totalPage", fruitdao.getPage());
		request.setAttribute("fylist", fylist);
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("/JSP/fyfruitlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}