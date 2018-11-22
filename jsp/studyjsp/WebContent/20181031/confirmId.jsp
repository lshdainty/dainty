<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="wdb20181031.LogonDBBean" %>
<% request.setCharacterEncoding("utf-8");%>

	<%
		String id = request.getParameter("id");
		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.confirmId(id);
		out.print(check);
	%>
