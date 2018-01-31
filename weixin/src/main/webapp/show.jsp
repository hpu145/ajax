<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>simditor</title>
	<link rel="stylesheet" href="/css/bootstrap.css" />
	<link rel="stylesheet" href="/js/editor/styles/simditor.css" />
</head>
<body>
	<div class="container">
		<div class="page-header">
			simditor 富文本编辑器 <small>http://simditor.tower.im/docs/doc-usage.html</small>
		</div>
		<div id="html">${html}</div>
	</div>
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script>
		$(function(){
			
			//$("#html").html();
			
		});
	
	</script>
</body>
</html>
