<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
</head>
<body>

	<script>
		function sayHello(data){
			alert("hello,jsonp," + data.name);
		}
	</script>
	
	
	<script src="http://localhost:8080/load.js?m=sayHello">
		<!-- sayHello({"name":jack,"age":23}); -->
	</script>
</body>
</html>