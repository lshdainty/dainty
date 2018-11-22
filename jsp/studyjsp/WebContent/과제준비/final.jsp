<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입력결과는??</h2>
	<%
		String gender = request.getParameter("gender");
		String name = (String)session.getAttribute("name");
	%>
	이름 : <%=name %>
	성별 : <%=gender %>
</body>
</html>