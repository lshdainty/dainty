<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*"%>

<%request.setCharacterEncoding("utf-8");%>
<%
	String result = "------------------------------<br>";
	String realFolder = "";
	String saveFolder = "/fileSave";
	String encType = "utf-8";
	int maxSize = 5*1024*1024;
	
	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	
	try{
		MultipartRequest upload = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
	}catch(Exception e){
		
	}
%>