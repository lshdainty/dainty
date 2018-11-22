<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="/shoppingmall/mngr/managerMain.js"></script>

<c:if test="${empty sessionScope.id}">
	<div id="mList"><p>로그인하세요.
	</div>
</c:if>
<c:if test="${not empty sessionScope.id}">
	<div id="mList">
		<ul>
			<li>상품관련 작업</li>
			<li><button id="registProduct">상품등록</button></li>
			<li><button id="updateProduct">상품수정/삭제</button></li>
		</ul>
		<ul>
			<li>구매된 상품관련 작업</li>
			<li><button id="orderedProduct">전체구매목록 확인</button></li>
		</ul>
		<ul>
			<li>상품 QnA 작업</li>
			<li><button id="qna">상품 QnA답변</button></li>
		</ul>
	</div>
</c:if>