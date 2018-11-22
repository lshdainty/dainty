<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--tablib 불러오기 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>list.do로 들어왔습니다.</h1>
	<c:if test="${not empty members}">
		<c:forEach var="m" items="${members}">
			id=${m.id}
			passwd=${m.passwd}
			name=${m.name}
			reg_date=${m.reg_date}
			address=${m.address}
			tel=${m.tel}
			</br>
		</c:forEach>
	</c:if>
</body>
</html>