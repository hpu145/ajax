<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
</head>
<body>
	<input type="text" id="input"/>
	<button id="btn">json</button>
	<script src="/js/jquery-3.2.1.js"></script>
	<script>
		$(function(){
						
			$("#btn").click(function(){
				var value = $("#input").val();
				/* $.get("/validates",{"name":value,"address":"beijing"},function(res){
					alert("res:" + res);
				}); */
				
				$.get("/validates",{"name":value}).done(function(res){
					alert("res:" + res);
				}).fail(function(){
					alert("系统异常，请稍候再试");
				});
				
			})
			
		});
	</script>
</body>
</html>