<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<%-- <frameset rows="20%,80%" frameborder="yes" framespacing="1">
	<frame src="${pageContext.request.contextPath}/JSP/top.jsp"
		 />
	<frameset cols="20%,80%" frameborder="yes" framespacing="5">
		<frame 
			src="${pageContext.request.contextPath}/JSP/left.jsp" />
		<frame  name="rightFrame"
			src="${pageContext.request.contextPath}/JSP/right.jsp" />
	</frameset>
</frameset> --%>
<body>
	<h1>首页</h1>
	<!-- <table>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table> -->
	<jsp:include page="/JSP/top.jsp"></jsp:include>
	<div>
		<a href="${pageContext.request.contextPath}/FruitListFY" >分页显示所有物品</a>
		<a href="${pageContext.request.contextPath}/FruitListServlet" >显示所有物品</a>
		<a href="${pageContext.request.contextPath }/BeforeAddServlet"  >添加物品</a>
		<a href="${pageContext.request.contextPath}/UserListServlet"  >显示用户信息</a>
		<a href="${pageContext.request.contextPath }/BeforeUserAdd"  >添加用户</a>
		<a href="${pageContext.request.contextPath }/User_FruitListServlet">用户与物品的关系</a>
		
		<a href="${pageContext.request.contextPath }/upServlet">上传文件</a>
		<a href="${pageContext.request.contextPath }/FileListServlet">下载文件</a>
	</div>

</body>
</html>