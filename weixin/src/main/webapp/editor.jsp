<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action="/edit" method="post" id="editorForm">
			<textarea id="editor" placeholder="Balabala" name="content" autofocus></textarea>
			<button class="btn btn-primary">save</button>
		
		</form>
		
	</div>
	
	<script src="/js/jquery-1.11.3.min.js"></script>
	
	<script src="/js/editor/scripts/module.js"></script>
	<script src="/js/editor/scripts/hotkeys.js"></script>
	<script src="/js/editor/scripts/uploader.js"></script>
	<script src="/js/editor/scripts/simditor.js"></script>
	
	<script>
		$(function(){
			var editor = new Simditor({
				  textarea: $('#editor'),
				  upload : {
					  url : "/file/upload2",
					  filekey : "file"
				  }
			});
			
			
		});
	
	</script>
</body>
</html>
