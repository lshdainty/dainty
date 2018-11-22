var status = true;

$(document).ready(function(){
	$("#checkId").click(function(){
		if($("#id").val()){
			var query = {id:$("#id").val()};
			
			$.ajax({
				type:"post",
				url:"confirmId.jsp",
				data:query,
				success:function(data){
					if(data == 1){
						alert("사용할 수 없는 아이디");
						$("#id").val("");
					}
					else if(data == -1){
						alert("사용할 수 있는 아이디");
					}
				}
			});
		}
		else{
			alert("사용할 아이디를 입력");
			$("#id").focus();
		}
	});
	
	$("#process").click(function(){
		checkIt();
		
		if(status){
			var query = {id:$("#id").val(),
						passwd:$("#passwd").val(),
						name:$("#name").val(),
						address:$("#address").val(),
						tel:$("#tel").val()
					};
			$.ajax({
				type:"post",
				url:"registerPro.jsp",
				data:query,
				success:function(data){
					$("#main_auth").load("loginForm.jsp");
				}//success
			});//ajax
		}//if
	});//process
	
	$("#cancle").click(function(){
		location.href = "main.jsp";
	});
});

function checkIt(){
	status = true;
	
	if(!$("#id").val()){
		alert("아이디를 입력하시오");
		$("#id").focus();
		status = false;
		return false;
	}
	
	if(!$("#passwd").val()){
		alert("비밀번호를 입력하시오");
		$("#passwd").focus();
		status = false;
		return false;
	}
	
	if($("#passwd").val() != $("#repass").val()){
		alert("비밀번호를 동일하게 입력하시오");
		$("#repass").focus();
		status = false;
		return false;
        }
    
        if(!$("#name").val()) {
                alert("사용자 이름을 입력하시오");
		$("#name").focus();
		status = false;
		return false;
	}
	
	if(!$("#address").val()){
		alert("주소를 입력하시오");
		$("#address").focus();
		status = false;
		return false;
	}
	
	if(!$("#tel").val()){
		alert("전화번호를 입력하시오");
		$("#tel").focus();
		status = false;
		return false;
	}
}