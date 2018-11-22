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
				<legend>QUESTION 2</legend>
				Your database interface is running. 
				A user SCOTT starts a SQL *Plus session, and issues the following query: 
				<br/>
				<br/>
				SQL> SELECT * FROM sales; 
				<br/>
				<br/>
				Which process would retrieve the result from the database and return it to the client program?
				<br/>
				<hr>
				<label for="q2_a">A</label>
				<input id="q2_a" name="q2" type="radio" value="a">
				User process<br/>
				<label for="q2_b">B</label>
				<input id="q2_b" name="q2" type="radio" value="b">
				Server process<br/>
				<label for="q2_c">C</label>
				<input id="q2_c" name="q2" type="radio" value="c">
				System Monitor (SMON)<br/>
				<label for="q2_d">D</label>
				<input id="q2_d" name="q2" type="radio" value="d">
				Process Monitor (PMON)<br/>
				<label for="q2_e">E</label>
				<input id="q2_e" name="q2" type="radio" value="e">
				Checkpoint process (CKPT)
			</fieldset>
		</dl>
		<input type="hidden" name="question" value="2">
		<input type="submit" value="전송">
	</form>
</body>
</html>