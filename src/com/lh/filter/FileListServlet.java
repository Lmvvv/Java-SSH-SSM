package com.lh.filter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String uploadFilePath = this.getServletContext().getRealPath("/upload");
		File file = new File(uploadFilePath);
		Map<String, String> fileNameMap = new HashMap<String, String>();
		filelist(file, fileNameMap);
		request.setAttribute("fileNameMap", fileNameMap);
		request.getRequestDispatcher("/WEB-INF/JSP/filelist.jsp").forward(request, response);
	}

	public void filelist(File file, Map<String, String> map) {
		// 判断file是否是文件，如果是目录
		if (!file.isFile()) {
			// 就列出该目录下的所有文件和目录
			File[] files = file.listFiles();
			for (File f : files) {
				filelist(f, map);
			}
		} else {
			String realname = file.getName().substring(file.getName().indexOf("_") + 1);
			String filename = file.getName();
			map.put(filename, realname);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}