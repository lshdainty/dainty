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
				<legend>QUESTION 3</legend>
				Examine the following command: 
				<br/>
				<br/>
				SQL> ALTER TABLE booking SHRINK SPACE COMPACT; 
				<br/>
				<br/>
				Which activity is performed when the preceding command is executed?
				<br/>
				<hr>
				<label for="q3_a">A</label>
				<input id="q3_a" name="q3" type="radio" value="a">
				The shrink operation touches every block in the BOOKING table<br/>
				<label for="q3_b">B</label>
				<input id="q3_b" name="q3" type="radio" value="b">
				The high-water mark (HWM) for the BOOKING table is shifted from its original position<br/>
				<label for="q3_c">C</label>
				<input id="q3_c" name="q3" type="radio" value="c">
				The progress of the shrink operation is saved in the bitmap blocks of the BOOKING table<br/>
				<label for="q3_d">D</label>
				<input id="q3_d" name="q3" type="radio" value="d">
				The data manipulation language (DML) triggers on the BOOKING table 
				are executed because the shrink operation is internally handled by the INSERT/DELETE operation
				<br/>
			</fieldset>
		</dl>
		<input type="hidden" name="question" value="3">
		<input type="submit" value="전송">
	</form>
</body>
</html>