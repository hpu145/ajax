<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	新浪微博</title>
	<link rel="stylesheet" href="/css/bootstrap.css" />
	
</head>
<body>
	<div class="container">
		<div id="alert" class="alert alert-warning" style="display:none"><a href="javascript:;" id="text"></a></div>
		<ul class="list-group" id="list">
			
		</ul>
	</div>
	
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script>
		$(function(){
			var maxId = null;
			$.get("/weibo").done(function(json){
				maxId = json[0].id; 
				for(var i = 0; i < json.length; i++) {
					var obj = json[i];
					var li = "<li class=\"list-group-item\">" + obj.message + "</li>"
					$("#list").append(li);
				}
				
			}).error(function(){
				alert("系统异常")
			});
			
			var data = null;
			
			// 轮询发请求，每10s一次
			setInterval(function(){
				$.get("/weibo",{"maxId" : maxId}).done(function(json){
					if(json.length) {
						data = json;
						$("#alert").show();
						$("#text").text("您有" + json.length + "条新微博，点击查看");
					}
					
				}).error(function(){
					alert("系统异常")
				});
				
				
			},10000);
			
			
			$("#text").click(function(){
				// alert框消失
				$("#alert").hide();
				
				// maxId 修改
				maxId = data[0].id;
				
				// 添加新数据
				for(var i = data.length - 1; i >= 0 ; i--) {
					var li = "<li class=\"list-group-item\">" + data[i].message + "</li>"
					$("#list").prepend(li);
				}
				
			});
			
		});
	
	
	</script>
</body>
</html>