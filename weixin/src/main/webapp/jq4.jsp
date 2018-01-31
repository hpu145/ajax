<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
</head>
<body>
	<button id="btn">getXML</button>
	<ul id="content"></ul>
	
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script>
		$(function(){
			$("#btn").click(function(){
				$.get("/users.xml").done(function(xml){
					$(xml).find("user").each(function(){
						var id = $(this).attr("id");
						var name = $(this).find("name").text();
						var address = $(this).find("address").text();
						/* console.log("id:" + id + ",name:" + name + ",address:" +address); */
						$("#content").append("<li>id:" + id + ",name:" + name + ",address:"+address + "</li>");
					
					
				}).error(function(){
					alert("系统异常");
				});
				
				
				
			});
			
			
			
		});
	
		});
	</script>
	
</body>
</html>