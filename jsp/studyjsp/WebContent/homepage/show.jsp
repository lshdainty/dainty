<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="homepage.homeBean, java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${homeList == null}">
		데이터가 없습니다......
	</c:if>
	<c:if test="${homeList != null }">
		<c:forEach var="p" items="${homeList }">
			${p.id}
			${p.name}
			${p.info}
			${p.price}
		</c:forEach>
	</c:if>
</body>
</html>