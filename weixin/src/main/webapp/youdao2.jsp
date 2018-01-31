<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我的翻译官	</title>
</head>
<body>
	<input type="text" id="word" />
	<button id="btn">翻译</button>
	<div id="content"></div>
	
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script>
	$(function(){
		
		$("#btn").click(function(){
			$("#content").html("");
			var word = $("#word").val();
			$.getJSON("/youdao2",{"p":word}).done(function(json){
				var array = json.basic.explains;
				for(var i =0 ; i < array.length; i++) {
					var explain = array[i];
					var p = "<p>" + explain + "</p>";
					$(p).appendTo($("#content"));
				}
			}).error(function(){
				alert("system error")
			});
			
			
			
		});

		
	});	
	</script>
</body>
</html>