<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="login.js"></script>
</head>
<body>
	<c:if test="${empty id} ">
		<div id="status">
			<ul>
				<li>
					<label for="id">아이디</label>
					<input id="id" name="id" type="text">
				</li>
				<li>
					<label for="passwd">패스워드</label>
					<input id="passwd" name="passwd" type="password">
				</li>
				<li class="label2">
					<button id="login">로그인</button>
					<button id="register">회원가입</button>
				</li>
			</ul>
		</div>
	</c:if>
	<c:if test="${not empty id} ">
		<div id="status">
			<ul>
				<li>
					<b>${id}</b>님 반갑습니다.
				</li>
				<li class="label2">
			</ul>
		</div>
	</c:if>
</body>
</html>