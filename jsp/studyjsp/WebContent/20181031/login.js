var status = true;

$(document).ready(function(){
	$("#register").click(function(){
		$("#main_auth").load("registerForm.jsp");
	});	//register
	
	$("#login").click(function(){
		checkIt();
		if(status){
			var query = {id:$("#id").val(),passwd:$("#passwd").val()};	//query
			
			$.ajax({
				type:"POST",
				url:"loginPro.jsp",
				data:query,
				success:function(data){
					if(data==1)
						$("#main_auth").load("loginForm.jsp");
					else if(data == 0){
						alert("비밀번호가 맞지 않습니다.");
						$("#passwd").val("");
						$("#passwd").focus();
              				} else if(data == -1){ // 아이디 틀림
                  				alert("아이디가 맞지 않습니다.");
                  				$("#id").val("");
                  				$("#passwd").val("");
                  				$("#id").focus();
					}	//else if -1
				}	//success
			});	//ajax
		}	//if
	});	//#login
	
	$("#update").click(function(){
		$("#main_auth").load("modify.jsp");
	});	//update
	
	$("#logout").click(function(){
		$.ajax({
			type:"POST",
			url:"logout.jsp",
			success:function(data){
				$("#main_auth").load("loginForm.jsp");
			}	//success
		});	//ajax
	});	//logout
});	//document

function checkIt(){
	status = true;
	
	if(!$.trim($("#id").val())){
		alert("아이디를 입력하세요.");
		$("#id").focus();
		status = false;
		return false;
	}	//if id
	
	if(!$.trim($("#passwd").val())){
		alert("비밀번호를 입력하시오");
		$("#passwd").focus();
		status = false;
		return false;
	}	//if passwd
}	//checkIt