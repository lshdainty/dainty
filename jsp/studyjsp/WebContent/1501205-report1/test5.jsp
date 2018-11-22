<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과</h2>
	<%
		int qcount = (int)session.getAttribute("qcount");
	
		out.print("당신의 점수는 : " + qcount + "점 입니다.");
	%>
	<form method="post" action="control.jsp">
		<input type="hidden" name="question" value="5">
		<input type="submit" value="끝내기">
	</form>
</body>
</html>