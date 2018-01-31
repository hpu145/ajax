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
	<button id="btn">save </button><img src="/img/loading.gif" id="img" style="width:30px"/>
	<span id="span"></span>
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script>
	
		$(function(){
			$("#img").hide();
			$("#btn").click(function(){
				/* $.post("/validate",{"name":$(this).val()}).done(function(res){
					alert("res:" + res);
				}).error(function(){
					alert("系统异常");
				}); */
				var value = $("#input").val();
				$.ajax({
					url : "/validate",
					type : "post",
					data : {"name" : value},
					beforeSend : function(){
						$("#btn").attr("disabled","disabled").text("saving");
						$("#img").show();
					},
					success : function(res){
						alert(res);
					},
					error : function() {
						alert("error");
					},
					complete : function(){
						$("#btn").removeAttr("disabled").text("save");
						$("#img").hide();
					}
				});
			});
			
		});
	
	</script>
</body>
</html>