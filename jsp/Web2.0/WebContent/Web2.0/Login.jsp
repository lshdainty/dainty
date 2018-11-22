<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="control.js"></script>
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<div id="BeforeLogin">
		<img src='https://www.yju.ac.kr/sites/kr/images/img_symbol_mark.png'
			width='300px' height='300px' /><br/>
		<button id="ToLogin">인트로 화면에서 로그인화면으로 가기</button>
	</div>
	<div id="Login" style="display:none;">
		<h1>My SNS Service</h1>
		<br/>
		<h3>로그인 해주세요</h3>
		<P>아이디</P>
		<input type="text" id="loginTxtID" maxlength="50"/>
		<p>비밀번호</p>
		<input type="password" id="loginTxtPw" maxlength="50"/>
		<br/><br/>
		<button id="loginBtnLogin">로그인</button>
		<button id="loginBtnJoin">회원가입</button>
	</div>
	<div id="finish">
	</div>
</body>
</html>