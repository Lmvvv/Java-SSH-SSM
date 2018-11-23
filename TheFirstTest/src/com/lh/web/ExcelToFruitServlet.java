package com.lh.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.service.ExcelToFruitService;

public class ExcelToFruitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ExcelToFruitService etfs=new ExcelToFruitService();
		if(etfs.excelToFruit()){
			response.getWriter().write("<h1 style='color:red;text-align:center'>"+
					"导入成功"+"</h1>");
			response.setHeader("Refresh", "2;url="+request.getContextPath()+"/FruitListFY");
		}else {
			response.getWriter().write("<h1 style='color:red;text-align:center'>"+
					"导入失败"+"</h1>");
			response.setHeader("Refresh", "2;url="+request.getContextPath()+"/FruitListFY");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}