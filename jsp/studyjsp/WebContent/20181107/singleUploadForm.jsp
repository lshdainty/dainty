<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<script src="../js/jquery-3.3.1.min.js"></script>	<%-- jquery 라이브러리 넣기 --%>
<script src="../js/jquery.form.js"></script>	<%-- jquery 파일 업로드를 위한 라이브러리 --%>
<script src="singleUpload.js"></script>	<%-- 버튼을 눌렀을때 발생하는 이벤트를 처리하는 java script외부 파일--%>
<%-- 파일저장시 이클립스에 폴더를 생성하고 서비 clean을 하면 파일저장 폴더도 같이 사라진다.
파일 폴더 생성 위치 경로 : D:\jsp\code\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\studyJSP
이곳에 폴더를 다시 생성해주고 파일을 실행하면 정상작동한다.--%>

<%-- 나머지 부분은 다 같으나 파일을 업로드 할 시 전송방식은 post로 get은 보낼수 있는 파일의 크기가 작기때문에 post로 한다. 
	  enctype은 서버에 폼 데이터를 전송 시 인코딩 방식을 지정하는 것으로 multipart/form-data는 전송 데이터를 인코딩하지 않으며 업로드할때 사용한다.--%>
<form id="upForm1" action="singleUploadPro.jsp" method="post" enctype="multipart/form-data">	
	<div id="form">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" size="20" autofocus>
			</li>
			<li>
				<label for="file1">파일선택</label>	<%-- 파일을 입력받기 위한 input으로 타입이 file이다. --%>
				<input type="file" id="file1" name="file1">
			</li>
			<li>
				<input type="submit" id="upPro1" value="단일 파일 업로드">
			</li>
		</ul>
	</div>
</form>
<div id="upResult"></div>
