<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>성별 입력받고 이름 session에 저장</h2>
	<%
		/*String name = request.getParameter("name");
		session.setAttribute("name",name);*/
		
		session.setAttribute("name",request.getParameter("name"));
	%>
	<form method="post" action="final.jsp">
		<label for="gender">남</label>
		<input id="gender" name="gender" type="radio" value="m">
		<label for="gender">여</label>
		<input id="gender" name="gender" type="radio" value="f">
		<input type="submit" value="입력">
	</form>
</body>
</html>