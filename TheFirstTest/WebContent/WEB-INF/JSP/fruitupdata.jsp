<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
</head>
<body>
	<h2>修改信息</h2>
	<jsp:include page="/JSP/top.jsp"></jsp:include>
	<hr />
	<form action="${pageContext.request.contextPath}/FruitUpdServlet"
		method="POST">
		<input type="hidden" name="id" value="${fruit.id}" />
		<table border="1">
			<tr>
				<td width="30%">名称</td>
				<td><input type="text" name="name" value="${ fruit.name }" /></td>
			</tr>

			<tr>
				<td>单价</td>
				<td><input type="text" name="price" value="${ fruit.price }" />
				</td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input type="text" name="num" value="${ fruit.num }" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="修改信息" /></td>
			</tr>
		</table>
	</form>
</body>
</html>