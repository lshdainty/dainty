<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8");%>
	<%
		String resultStr = "처리결과:<br>";
		String name = request.getParameter("name");
		String stus = request.getParameter("stus");
		resultStr += "이름은" + name + "이고,<br>";
		resultStr += "현재 상태는" + stus;
		out.println(resultStr);
	%>
</body>
</html>