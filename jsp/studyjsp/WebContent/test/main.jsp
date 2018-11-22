<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="control.jsp">
		<label for="q1">1번</label>
		<input id="q1" type="checkbox" name="choose" value="1">
		<label for="q2">2번</label>
		<input id="q2" type="checkbox" name="choose" value="2">
		<label for="q3">3번</label>
		<input id="q3" type="checkbox" name="choose" value="3">
		<label for="q4">4번</label>
		<input id="q4" type="checkbox" name="choose" value="4">
		<input type="submit" value="전송">
	</form>
</body>
</html>