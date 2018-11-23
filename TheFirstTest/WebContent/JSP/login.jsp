<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/LoginServlet1"
		method="POST">
		用户名:<input type="text" name="username"><br> 
		密 &nbsp;码:<input type="password" name="password"><br> 
		<!-- <label> <input type="checkbox" name="autologin" value="autologin"> 自动登录</label><br> -->
			<input	type="submit" value="登陆"><br />
	</form>


</body>
</html>