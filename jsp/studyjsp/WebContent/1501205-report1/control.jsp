<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%-- 오답 혹은 정답 확인 페이지 --%>
</head>
<body>
	<%-- 몇점인지 계산하기 위한 변수--%>
	<%!int qcount=0; %>
	
	<%
		//사용자가 선택한 보기를 변수에 담는다.
		String q1 = request.getParameter("q1");
		session.setAttribute("q1",q1);
		
		String q2 = request.getParameter("q2");
		session.setAttribute("q2",q2);
		
		String q3 = request.getParameter("q3");
		session.setAttribute("q3",q3);
		
		String[] q4 = request.getParameterValues("q4");
		session.setAttribute("q4",q4);
		
		
		//문제 번호를 저장한다.
		String question = request.getParameter("question");
		session.setAttribute("question",question);
		int number = Integer.parseInt(question);

		
		
		//각 문제 번호로 가서 다음 문제로 가던지 오답해설페이지로 간다.
		switch(number){
			case 1:
				if(q1.equals("d")){
					qcount = qcount + 1;
					session.setAttribute("qcount",qcount);
					response.sendRedirect("test2.jsp");
				}
				else{
					response.sendRedirect("wrong.jsp");
				}
			break;
			
			case 2:
				if(q2.equals("b")){
					qcount = qcount + 1;
					session.setAttribute("qcount",qcount);
					response.sendRedirect("test3.jsp");
				}
				else{
					response.sendRedirect("wrong.jsp");
				}
			break;
			
			case 3:
				if(q3.equals("c")){
					qcount = qcount + 1;
					session.setAttribute("qcount",qcount);
					response.sendRedirect("test4.jsp");
				}
				else{
					response.sendRedirect("wrong.jsp");
				}
			break;
			
			case 4:
				String[] test = {"a","b","d"};
				int count=0;
				
				for(int i=0; i<q4.length; i++){
					if(q4[i].equals(test[i])){
						count++;
					}
				}
				
				if(count==3){
					qcount = qcount + 1;
					session.setAttribute("qcount",qcount);
					response.sendRedirect("test5.jsp");
				}
				else{
					response.sendRedirect("wrong.jsp");
				}
			break;
			
			case 5:
				qcount = 0;
		}
	%>
	
	<script language="javascript">
		    
		    top.window.opener = top;
		    top.window.open('','_parent', '');
		    top.window.close();
	</script>
</body>
</html>