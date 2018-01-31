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
	
	<script src="/js/xmlHttp.js"></script>
	<script>
		(function(){
			var btn = document.getElementById("btn");
			var content = document.getElementById("content");
			
			btn.onclick = function(){
				var xmlHttp = ajax.createXmlHttp();
				
				xmlHttp.open("GET","/users.xml");
				xmlHttp.onreadystatechange = function(){
					if(xmlHttp.readyState == 4) {
						if(xmlHttp.status == 200) {
							
							var xmlDom = xmlHttp.responseXML;
							var tags = xmlDom.getElementsByTagName("user");
							for(var i = 0; i < tags.length; i++) {
								var userTag = tags[i];
								var id = userTag.getAttribute("id");
								var name = userTag.getElementsByTagName("name")[0]
								.childNodes[0].nodeValue;
								/* console.log("id:" + id + ",name: " + name); */
								  var li = document.createElement("li"); 
								  var span = document.createElement("span");
								  var text = document.createTextNode(id + "," + name);
								  span.appendChild(text);
								  li.appendChild(span);
								  content.appendChild(li);
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