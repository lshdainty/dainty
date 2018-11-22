<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/jquery.form.js"></script>
<script src="multiUpload.js"></script>
</head>
<body>
	<form id="upForm1" action="multiUploadPro.jsp" method="post" enctype="multipart/form-data">
		<div id="form">
			<ul>
				<li>
					<p class="cau">* 파일선택기에서 ctrl,shift 키를 눌러 파일을 다중선택 하십시오.</p>
					<label for="file1">파일선택</label>
					<input type="file" id="file1" name="file1" multiple>
				</li>
				<li>
					<input type="submit" id="upPro1" value="다중 파일 업로드">
				</li>
			</ul>
		</div>
	</form>
	<div id="upResult"></div>
</body>
</html>