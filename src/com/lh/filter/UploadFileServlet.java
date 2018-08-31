package com.lh.filter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

public class UploadFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 使用Apache文件上传组件处理文件上传
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);// 创建一个文件上传解析器
		sfu.setHeaderEncoding("utf-8");
		factory.setSizeThreshold(1024 * 500);
		String savePath = this.getServletContext().getRealPath("/upload");
		File f = new File(savePath);
		factory.setRepository(f);
		try {
			List<FileItem> fileitems = sfu.parseRequest(request);
			for (FileItem fileitem : fileitems) {
				if (fileitem.isFormField()) {
					String name = fileitem.getFieldName();
					String value = fileitem.getString("utf-8");
					System.out.println(name + ":" + value);
				} else {
					String filename = fileitem.getName();
					long size = fileitem.getSize();
					InputStream in = fileitem.getInputStream();
					byte[] buffer = new byte[1024];
					int len = 0;
					String file = savePath + "\\" + filename;
					OutputStream out = new FileOutputStream(file);
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.close();
					in.close();

				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write("<h1 style='color:red;text-align:center'>上传成功</h1>");
		response.setHeader("Refresh", "2;url="+request.getContextPath()+"/FileListServlet");
		//request.getRequestDispatcher("/WEB-INF/JSP/upload.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}