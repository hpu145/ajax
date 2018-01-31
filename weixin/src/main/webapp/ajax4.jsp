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
	
	<script src="/js/xmlHttp.js"></script>
	<script>
		(function(){
			var btn = document.getElementById("btn");
			var content = document.getElementById("content");
			
			btn.onclick = function(){
				var xmlHttp = ajax.createXmlHttp();
				
				xmlHttp.open("GET","/users.json");
				xmlHttp.onreadystatechange = function(){
					if(xmlHttp.readyState == 4) {
						if(xmlHttp.status == 200) {
							
							//获取的是服务端的json字符串
							var textJson = xmlHttp.responseText;
							// json字符串转化json对象
							var json = JSON.parse(textJson);
							//console.log(json.length);
							for(var i = 0; i < json.length; i++) {
								var obj = json[i];
								console.log("id:" + obj.id + ",name:" + obj.name);
							}
							
						} else {
							alert("系统异常，请稍后再试");
						}
					}
				}
				xmlHttp.send();
				
			}
			
			
		})();
	
	
	</script>
	
</body>
</html>