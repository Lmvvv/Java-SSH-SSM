<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
</head>
<body>
	<h1 align="center">下载文件</h1>
	<hr>
	<jsp:include page="/JSP/top.jsp"></jsp:include>
	<hr>
	
	<table align="center" border="1">
		<tr>
			<th>文件</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${fileNameMap }" var="fileName">
			<tr>
				<td width="500">${fileName.value}</td>
				<td><a href="${pageContext.request.contextPath }/DownLoadServlet?filename=${fileName.value}">文件下载</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>