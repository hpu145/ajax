<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
</head>
<body>
	<button id="btn">json</button>
	<script src="/js/jquery-3.2.1.js"></script>
	<script>
		$(function(){
						
			$("#btn").click(function(){
				$.get("/hello");
			})
			
		});
	</script>
</body>
</html>