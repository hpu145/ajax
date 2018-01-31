<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
</head>
<body>
	<button id="btn">getJSON</button>
	<ul id="content"></ul>
	
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script>
		$(function(){
			
			$("#btn").click(function(){
				$.getJSON("/users.json").done(function(json){
					// jquery不用把json字符串解析为json对象，因为获得的json本身就是json对象
					for(var i = 0; i < json.length; i++) {
						var user = json[i];
						var html = "<li>" + user.id + "-->" + user.name + "-->" + user.address + "</li>";
						$("#content").append(html);
					}
					
				}).error(function(){
					alert("system error")
				});
				
				
				
			});
			
			
			
			
			
		});
	
	
	</script>
	
</body>
</html>