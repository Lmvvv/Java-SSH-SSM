<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<frameset rows="20%,80%" frameborder="yes" framespacing="1">
	<frame src="${pageContext.request.contextPath}/JSP/top.jsp"
		 />
	<frameset cols="20%,80%" frameborder="yes" framespacing="5">
		<frame noresize="noresize"
			src="${pageContext.request.contextPath}/JSP/left.jsp" />
		<frame noresize="noresize" name="rightFrame"
			src="${pageContext.request.contextPath}/JSP/right.jsp" />
	</frameset>
</frameset>
<body>

</body>
</html>