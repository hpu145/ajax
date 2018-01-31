<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
</head>
<body>
	<button id="btn">jsonpJquery</button>
	
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script>
		$(function(){
			$("#btn").click(function(){
				$.getJSON("/load.js?m=?",function(data){
						alert("name:" + data.name);
				});
				
			});
			
		});
	
	</script>
</body>
</html>