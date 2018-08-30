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
	<h1 align="center">所有的物品</h1>


	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>库存数量</th>
			
			<th>操 作</th>
		</tr>
		<c:forEach items="${list}" var="fruit">
			<tr>
				<td>${fruit.id}</td>
				<td>${fruit.name}</td>
				<td>${fruit.price}</td>
				<td>${fruit.num}</td>
				
				<td><a id="delFruit"
					href="${pageContext.request.contextPath}/FruitDelServlet?id=${fruit.id}">删除</a>
					<a id="updFruit"
					href="${pageContext.request.contextPath}/FruitServlet?id=${fruit.id}">修改</a>
					
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>