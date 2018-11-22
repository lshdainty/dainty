<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="wdb20181031.LogonDBBean" %>
<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="member" class="wdb20181031.LogonDataBean">
		<jsp:setProperty name="member" property="*"/>
	</jsp:useBean>
	<%
		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.updateMember(member);
		
		out.print(check);
	%>