<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이 페이지는 ocp문제은행입니다.</h2>
	<form method="post" action="control.jsp">
		<dl>
			<fieldset>
				<legend>QUESTION 4</legend>
				What are the prerequisites for performing flashback transactions? (Choose all that apply)
				<br/>
				<hr>
				<label for="q4_a">A</label>
				<input id="q4_a" name="q4" type="checkbox" value="a">
				Supplemental log must be enabled<br/>
				<label for="q4_b">B</label>
				<input id="q4_b" name="q4" type="checkbox" value="b">
				Supplemental log must be enabled for the primary key<br/>
				<label for="q4_c">C</label>
				<input id="q4_c" name="q4" type="checkbox" value="c">
				Undo retention guarantee for the database must be configured<br/>
				<label for="q4_d">D</label>
				<input id="q4_d" name="q4" type="checkbox" value="d">
				”EXECUTE “ permission on the DBMS_FLASHBACK package must be granted to the user<br/>
			</fieldset>
		</dl>
		<input type="hidden" name="question" value="4">
		<input type="submit" value="전송">
	</form>
</body>
</html>