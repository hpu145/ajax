<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>	</title>
</head>
<body>
	<input type="text" id="name"/>
	<span id="span"></span>
	<script src="/js/xmlHttp.js"></script>
	<!-- <script src="/js/xmlHttp2.js"></script> -->
	<script>
	
		(function(){
			
			var name = document.getElementById("name");
			name.onchange = function(){
				var username = encodeURIComponent(name.value);
				var xmlHttp = ajax.createXmlHttp(); 
				xmlHttp.open("POST","/validate");
				// 设置该报文属性用于模拟普通表单提交
				// post没有字节数限制
				// post不会被浏览器缓存
				xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
				xmlHttp.onreadystatechange = function(){
					if(xmlHttp.readyState == 4) {
						if(xmlHttp.status == 200) {
							var res = xmlHttp.responseText;
							document.getElementById("span").innerText = res;
						}
					}
				}
				xmlHttp.send("name=" + username);
			}
			
		})();
	
	</script>
</body>
</html>