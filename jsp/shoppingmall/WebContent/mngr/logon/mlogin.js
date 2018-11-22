$(document).ready(function(){
	//로그인 버튼을 클릭하면 자동 실행
	$("#login").click(function(){
		var query = {
				id:$("#id").val(),
				passwd:$("#passwd").val()
		};	//query
		$.ajax({
			type:"post",
			url:"/shoppingmall/mg/managerLoginPro.do",
			data:query,
			success:function(data){
				window.location.href="/shoppingmall/mg/managerMain.do";
			}
		});	//ajax
	});	//login
	
	$("#logout").click(function(){
		$.ajax({
			type:"post",
			url:"/shoppingmall/mg/managerLogout.do",
			success:function(data){
				window.location.href="/shoppingmall/mg/managerMain.do";
			}
		});	//ajax
	});//logout
});	//document