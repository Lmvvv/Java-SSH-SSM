<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script language=JavaScript>
	var timerID = null;
	var timerRunning = false;
	function stopclock() {
		if (timerRunning)
			clearTimeout(timerID);
		timerRunning = false;
	}
	function startclock() {
		stopclock();
		showtime();
	}

	function showtime() {
		var now = new Date();

		document.clock.thetime.value = now.toString();
		timerID = setTimeout("showtime()", 1000);
		timerRunning = true;
	}
</script>
</head>
<body onload="startclock()">
	<ul>
		<li><form name=clock>
				<input name=thetime size=100>
			</form>
		<li>Server:<%=application.getServerInfo()%>
		<li>username:<%=session.getAttribute("username") %>
		<li><form action="${pageContext.request.contextPath}/LoginOutServlet">
				<input type="submit" value="退出">
			</form>
	</ul>
</body>
</html>