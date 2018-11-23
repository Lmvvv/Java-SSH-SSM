<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">用户与物品</h1>
<jsp:include page="/JSP/top.jsp"></jsp:include>

	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>用户ID</th>
			<th>物品ID</th>
			<th>操 作</th>
		</tr>
		<c:forEach items="${uflist}" var="user_fruit">
			<tr>
				<td>${user_fruit.id}</td>
				<td>${user_fruit.userid}</td>
				<td>${user_fruit.fruitid}</td>
				<td><a 
					href="${pageContext.request.contextPath}?id=${user_fruit.id}">删除</a>
					<a 
					href="${pageContext.request.contextPath}?id=${user_fruit.id}">修改</a>
					
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>