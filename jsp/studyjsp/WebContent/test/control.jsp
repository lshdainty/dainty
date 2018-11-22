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
	<%!	//main.jsp에서 사용자가 선택한 문제 번호를 기억하는 변수
		ArrayList<String> list = new ArrayList<String>();	//배열관리를 위한 ArrayList를 사용
		int count = 0;	//처음인지 2번째인지를 구별하기위한 변수
		int qcount = 0;
	%>
	<%
		count++;	//count증가
		String s;	//ArrayList에서 데이터를 가져와서 저장하기 위한 변수
		
		if(count==1){
			String[] choose = request.getParameterValues("choose");	//초기 한번만 사용자가 선택한 번호를 저장한다.
			for(int i = 0; i<choose.length; i++){
				list.add(choose[i]);	//list에 사용자가 선택한 번호를 저장하는 부분
				qcount++;
			}
			s = list.get(0);	
			list.remove(0);
			response.sendRedirect("test" + s + ".jsp");
		}
		else{
			if(count!=(qcount+1)){
				s = list.get(0);
				list.remove(0);
				response.sendRedirect("test" + s + ".jsp");
			}
			else{
				count = 0;
				qcount = 0;
				session.invalidate();
				response.sendRedirect("result.jsp");
			}
		}
	%>
</body>
</html>