<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
	<h1>上传文件</h1>
	<hr>
	<jsp:include page="/JSP/top.jsp"></jsp:include>
	<hr>
	<form action="${pageContext.request.contextPath }/UploadFileServlet" 
					enctype="multipart/form-data" method="POST">
		文件上传：<input type="file" name="fileupload"><br>
			<input type="submit" value="提交">
			<br>
	</form>
	
</body>
</html>
