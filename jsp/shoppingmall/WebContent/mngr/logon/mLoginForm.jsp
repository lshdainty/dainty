<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="/shoppingmall/mngr/logon/mlogin.js"></script>

<c:if test="${empty sessionScope.id}">
	<div id="status">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input id="id" name="id" type="text" size="20">
				<label for="passwd">비밀번호</label>
				<input id="passwd" name="passwd" type="password" size="20">
				<button id="login">로그인</button>
			</li>
		</ul>
	</div>
</c:if>
<c:if test="${not empty sessionScope.id }">
	<div id="status">
		<ul>
			<li>관리자 로그인 성공! 작업중
			<button id="logout">로그아웃</button>
		</ul>
	</div>
</c:if>