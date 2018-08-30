package com.lh.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.dao.UserDelDao;
import com.lh.service.UserDelService;

public class UserDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		UserDelService uds=new UserDelService();
		boolean isDelSuccess=uds.userdel(id);
		
		response.setContentType("text/html;charset=UTF-8");
		if(isDelSuccess){
			response.getWriter().write("删除成功！");
			response.setHeader("Refresh", "1;url=" + request.getContextPath() + "/UserListServlet");
		}else{
			response.getWriter().write("删除失败！");
		}
//		UserDelDao userdeldao=new UserDelDao();
//		userdeldao.delUser(id);
//		userdeldao.delUser_fruit(id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}