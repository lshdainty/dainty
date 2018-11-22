<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%request.setCharacterEncoding("utf-8"); %>

<%
	String result = "---------------------<br>";	//결과 문자열
	String realFolder = "";	//웹 애플리케이션상의 절대 경로 저장
	String saveFolder = "/fileSave";	//파일 업로드 폴더 지정
	String encType = "utf-8";	//인코딩 타입
	int maxSize = 5*1024*1024;	//파일업로드 최대 사이즈
	
	//jsp 페이지의 웹 애플리케이션상의 절대 경로를 구한다.
	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	
	try{
		MultipartRequest upload = null;
		
		upload = new MultipartRequest(request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());	//파일 업로드를 수행하는 multipartRequest 객체 생성
		
		Enumeration<?> params = upload.getParameterNames();	//<input type="file">이 아닌 것을 모두 불러온다.
		
		//파일이 아닌 파라미터들의 값을 반복해서 얻어냄
		while(params.hasMoreElements()){
			String name = (String)params.nextElement();	//파라미터명
			String value = upload.getParameter(name);	//파라미터값
			result += name + ":" + value +"<br>";	//결과 문자열 누적
		}	//이 파일에서는 file이 아닌것이 title뿐이라서 title만 들어간다.
		
		Enumeration<?> files = upload.getFileNames();	//<input type="file">인 것을 모두 불러온다.
		
		while(files.hasMoreElements()){
			String name = (String)files.nextElement();	//파라미터명
			String filename = upload.getFilesystemName(name);	//서버에 업로드된 파일명
			String original = upload.getOriginalFileName(name);	//원래 파일명
			String type = upload.getContentType(name);	//파일 종류
			
			//문자열 총합
			result += "파라미터 이름 : " + name + "<br>";
			result += "실제 파일 이름 : " + original + "<br>";
			result += "저장된 파일 이름 : " + filename + "<br>";
			result += "파일 타입 : " + type + "<br>";
			
			//업로드된 파일의 정보를 얻어내기 위해 file 객체로 생성
			File file = upload.getFile(name);
			if(file != null)
				result += "크기 : " + file.length() + "bytes <br>";	//파일크기
		}
		
		result += "-------------------------------<br>";
		out.println(result);	//처리 결과 반환
	}catch(Exception e){
		
	}
%>
