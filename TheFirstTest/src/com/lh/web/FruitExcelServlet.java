package com.lh.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.service.FruitFYExcel;

public class FruitExcelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int pageNo=Integer.parseInt(request.getParameter("pageNo"));
		FruitFYExcel fruitfyexcel=new FruitFYExcel();
		if(fruitfyexcel.fruitFYExcel(pageNo)){
			response.getWriter().write("已经成功生成Excel表格，并存到G盘！");
			response.setHeader("Refresh", "2;url="+request.getContextPath()+"/FruitListFY");
		}else {
			response.getWriter().write("生成失败！");
			response.setHeader("Refresh", "2;url="+request.getContextPath()+"/FruitListFY");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}