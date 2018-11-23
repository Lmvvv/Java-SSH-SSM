<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>用户首页</h1>
	<jsp:include page="/JSP/top.jsp"></jsp:include>
	<div>
		<a href="${pageContext.request.contextPath}/FruitListFY" >分页显示所有物品</a>
		<a href="${pageContext.request.contextPath}/FruitListServlet" >显示所有物品</a>
		<a href="${pageContext.request.contextPath}/MyFruitListServlet" >显示自己的物品</a>
	</div>
</body>
</html>