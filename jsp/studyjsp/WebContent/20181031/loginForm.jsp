<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="login.js"></script>
	<c:if test="${empty id}">
		<div id="status">
			<ul>
				<li>
					<label for="id">아이디</label>
					<input id="id" name="id" type="email" size="20" maxlength="50">
				</li>
				<li>
					<label for="passwd">비밀번호</label>
					<input id="passwd" name="passwd" type="password" size="20" maxlength="16">
				</li>
				<li class="label2">
					<button id="login">로그인</button>
					<button id="register">회원가입</button>
				</li>
			</ul>
		</div>
	</c:if>
	<c:if test="${not empty id}">
		<div id="status">
			<ul>
				<li><b>${id}</b>님이 로그인하였습니다.</li>
				<li class="label2">
					<button id="logout">로그아웃</button>
					<button id="update">회원 정보 변경</button>
				</li>
			</ul>
		</div>
	</c:if>