<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>添加用户</h2>
<jsp:include page="/JSP/top.jsp"></jsp:include>
	<hr />
	<form action="${pageContext.request.contextPath}/UserAddServlet"
		method="POST">
		<table border="1">
			<tr>
				<td width="30%">姓名</td>
				<td><input type="text" name="username" value="${ user.username }" /></td>
			</tr>

			<tr>
				<td>密码</td>
				<td><input type="text" name="password" value="${ user.password }" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="添加信息" /></td>
			</tr>
		</table>
	</form>
</body>
</html>