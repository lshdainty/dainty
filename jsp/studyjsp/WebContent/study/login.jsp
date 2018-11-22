<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="control.jsp">
		<table>
			<tr>
				<td>아이디</td>
				<td><input id="id" name="id" type="text"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input id="password" name="password" type="text"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
				<td><input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>
</body>
</html>