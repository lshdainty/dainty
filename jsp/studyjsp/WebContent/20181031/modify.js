var status = true;

$(document).ready(function(){
	$("#modify").click(function(){
		var query = {passwd:$("#passwd").val()	};	//query
		
		$.ajax({
			type:"POST",
			url:"memberCheck.jsp",
			data:query,
			success:function(data){
				if(data ==1){
					$("#main_auth").load("modifyForm.jsp?passwd="+$("#passwd").val());
				}else{
					alert("비밀번호가 맞지 않습니다.");
					$("#passwd").val("");
					$("#passwd").focus();
				}	//else
			}	//success
		});	//ajax
	});	//modify
	
	$("#modifyProcess").click(function(){
		var query = {
				id:$("#id").val(),
				passwd:$("#passwd").val(),
				name:$("#name").val(),
				address:$("#address").val(),
				tel:$("#tel").val()
		};	//query
		
		$.ajax({
        	 	type:"post",
			url:"modifyPro.jsp",
			data:query,
			success:function(data){
				if(data ==1){
					alert("회원 정보가 수정되었습니다.");
					location.href="main.jsp";
				}	//if
			}	//success
		});	//ajax
	});	//modifyProcess
	
	$("#cancle").click(function(){
		location.href="main.jsp";
	});	//cancle
	
	$("#delete").click(function(){
		var query = {
				passwd:$("#passwd").val()
		};	//query
		
		$.ajax({
			type:"post",
			url:"memberCheck.jsp",
			data:query,
			success:function(data){
				if(data ==1){
					$.ajax({
						type:"POST",
						url:"deletePro.jsp",
						data:query,
						success:function(data){
							if(data ==1 ){
								alert("회원 탈퇴가 되었습니다.");
								location.href = "main.jsp";
							}	//if
						}	//success
					});	//ajax
				}	//if
				else{
					alert("비밀번호가 맞지 않습니다.");
					$("#passwd").val("");
					$("#passwd").focus();					
				}	//else
			}	//success
		});	//ajax
	});	//delete
});	//document