$(document).ready(function(){
	$("#ToLogin").click(function(){
		$("#BeforeLogin").css('display','none');
		$("#Login").css('display','block');
	});	//ToLogin
	
	$("#loginBtnLogin").click(function(){
		var query = {
				id:$("#loginTxtID").val(),
				passwd:$("#loginTxtPw").val()
		};	//query
		alert("test");
		$.ajax({
			url:"database.jsp",
			data:query,
			success:function(data){
				if(data==0){
					alert("비밀번호가 맞지 않습니다.");
				}
				else if(data==-1){
					alert("아이디가 맞지 않습니다.");
				}
				else{
					var user = JSON.parse(data);
					console.log(user);
					alert("안녕하세요,<b>"+user[0].mname+"</b>님.");
					$("#finish").html("안녕하세요, <h1>"+user[0].mname+"</h1> 님.");
				}
			}	//success
		});	//ajax
	});	//loginBtnLogin
});	//document