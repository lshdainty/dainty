<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ocp문제 은행</title>
</head>
<body>
	<h2>이 페이지는 ocp문제은행입니다.</h2>
	<form method="post" action="control.jsp">
		<dl>
			<fieldset>
				<legend>QUESTION 1</legend>
				You are using recovery Manager (RMAN) with a recovery catalog to backup up your production database. 
				The backups and the archived redo log files are copied to a tape drive on a daily basis. 
				The database was open and transactions were recorded in the redo logs. 
				Because of fire in the building you lost your servers having the production database and the recovery catalog database. 
				<br/>
				The archive log files generated after the last backup are intact on one of the remote locations. 
				While performing a disaster recovery of the production database what is the next step that you must perform after restoring the data files and applying archived redo logs?
				<br/>
				<hr>
				<label for="q1_a">A</label>
				<input id="q1_a" name="q1" type="radio" value="a">
				Open the database in NORMAL mode<br/>
				<label for="q1_b">B</label>
				<input id="q1_b" name="q1" type="radio" value="b">
				Open the database in read-only mode<br/>
				<label for="q1_c">C</label>
				<input id="q1_c" name="q1" type="radio" value="c">
				Open the database in RESTRICTED mode<br/>
				<label for="q1_d">D</label>
				<input id="q1_d" name="q1" type="radio" value="d">
				Open the database with the RESETLOGS option
			</fieldset>
		</dl>
		<input type="hidden" name="question" value="1">
		<input type="submit" value="전송">
	</form>
</body>
</html>