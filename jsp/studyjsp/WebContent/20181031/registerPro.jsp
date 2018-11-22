<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="wdb20181031.LogonDBBean" %>
<%@ page import="java.sql.Timestamp" %>
<%request.setCharacterEncoding("utf-8"); %>
<script src="../js/jquery-3.3.1.min.js"></script>

	<jsp:useBean id="member" class="wdb20181031.LogonDataBean">
		<jsp:setProperty name="member" property="*" />
	</jsp:useBean>
	<%
		member.setReg_date(new Timestamp(System.currentTimeMillis()));
	
		LogonDBBean manager = LogonDBBean.getInstance();
		manager.insertMember(member);
	%>