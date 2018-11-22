<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이름을 입력해주세요</h2>
	<form method="post" action="session.jsp">
		<label for="name">이름</label>
		<input id="name" name="name" required>
		<input type="submit" value="입력">
	</form>
</body>
</html>