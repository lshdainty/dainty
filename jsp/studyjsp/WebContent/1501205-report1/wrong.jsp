<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String question = (String)session.getAttribute("question");
	
		int number = Integer.parseInt(question);
		
		switch(number){
			case 1:
				out.print("Correct Answer: D"+"<br/>");
				out.print("Section: Backup, Recovery & Recovery Manager (RMAN)"+"<br/>");
				out.print("Explanation"+"<br/>");
				out.print("Explanation/Reference: Section: Backup, Recovery & Recovery Manager (RMAN)");
			break;
			
			case 2:
				out.print("Correct Answer: B"+"<br/>");
				out.print("Section: SQL, PL/SQL, Packages, Functions, Jobs & Views"+"<br/>");
				out.print("Explanation"+"<br/>");
				out.print("Explanation/Reference: Section: SQL, PL/SQL, Packages, Functions, Jobs & Views");
			break;
	
			case 3:
				out.print("Correct Answer: C"+"<br/>");
				out.print("Section: SQL, PL/SQL, Packages, Functions, Jobs & Views"+"<br/>");
				out.print("Explanation"+"<br/>");
				out.print("Explanation/Reference: Section: SQL, PL/SQL, Packages, Functions, Jobs & Views");
			break;
	
			case 4:
				out.print("Correct Answer: ABD"+"<br/>");
				out.print("Section: Flashback Operations & Configuration"+"<br/>");
				out.print("Explanation"+"<br/>");
				out.print("Explanation/Reference: Section: Flashback Operations , Configuration ");
				break;
			}
		
		
	%>
	<form method="post" action="test<%=number+1 %>.jsp">
		<input type="submit" value="다음페이지">
	</form>
</body>
</html>