<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
</head>
<body>
	<button id="btn">ajax</button>


<script>
	(function(){
		var btn = document.getElementById("btn");
		
		btn.onclick = function(){
			var xmlHttp;
			// 浏览器兼容，判断是否为IE8以下
			if(window.ActiveXObject) {
				// 获得ajax引擎对象
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} else {
				// 获得ajax引擎对象
				xmlHttp = new XMLHttpRequest();
			}
			// 设置请求方式（GET|POST）和请求地址
			/* xmlHttp.open("GET","/hello?_=" + new Date().getTime()); */
			xmlHttp.open("GET","/hello");
			// 发送请求
			xmlHttp.send();
		}
		
		
	})();

</script>

</body>



</html>