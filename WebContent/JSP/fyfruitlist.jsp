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
	<h1 align="center">分页显示</h1>
	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>商品名称</th>
			<th>商品单价</th>
			<th>库存数量</th>
			<th>操 作</th>
		</tr>
		<c:forEach items="${fylist}" var="fruit">
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
	<!-- 分页下面那些  下一页和上一页 -->
	<a href="FruitListFY?pageNo=1">第一页</a>
	<c:if test="${pageNo>1}">
		<a href="FruitListFY?pageNo=${pageNo-1}">上一页</a>	
	</c:if>
	
	
	<c:if test="${pageNo<totalPage}">
		<a href="${pageContext.request.contextPath}/FruitListFY?pageNo=${pageNo+1}">下一页</a>	
	</c:if>
	<a href="${pageContext.request.contextPath}/FruitListFY?pageNo=${totalPage}">最后页</a>
	
</body>
</html>