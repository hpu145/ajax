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
				xmlHttp.open("GET","/validate?name=" + username);
				xmlHttp.onreadystatechange = function(){
					var code = xmlHttp.readyState;
					// 判断服务器状态码 ==4表示响应完毕
					if(code == 4) {
						// 判断Http状态码 
						if(xmlHttp.status == 200) {
							// 获得服务器返回的文本
							var res = xmlHttp.responseText;
							console.log(res);
							console.log(res == "yes");
							if(res == "yes") {
								document.getElementById("span").innerText = "✔";
							} else {
								document.getElementById("span").innerText = "✖";
							}
						} 
						
					}
				}
				xmlHttp.send();
			}
			
		})();
	
	</script>
</body>
</html>