<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body margin="0">
	<div>
		<div><a href="${pageContext.request.contextPath}/FruitListFY" target="rightFrame">分页显示所有物品</a></div>
		<div><a href="${pageContext.request.contextPath}/FruitListServlet" target="rightFrame">显示所有物品</a></div>
		<div><a href="${pageContext.request.contextPath}/MyFruitListServlet" target="rightFrame">显示自己的物品</a></div>
		<div><a href="fruitadd.jsp" target="rightFrame" >添加物品</a></div>
	</div>

</body>
</html>