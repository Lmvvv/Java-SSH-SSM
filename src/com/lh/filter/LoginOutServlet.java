package com.lh.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", null);
		session.setAttribute("password", null);
//		String username = (String) session.getAttribute("username");
//		String password = (String) session.getAttribute("password");
//		System.out.println("LoginOutServlet " + "username=" + username + " password=" + password);

		System.out.println("111111111");
		// 获得Cookie对象
		Cookie[] cookies = request.getCookies();
		// 通过cookie的name获取想要的
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if (cookieName.equals("JSESSIONID")) {
					cookie.setPath("/TheFirstTest/");
					cookie.setMaxAge(60);
					response.addCookie(cookie);
				}
			}
		}

		// request.getRequestDispatcher("/JSP/login.jsp").forward(request,
		// response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}