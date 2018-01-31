<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>文件上传</title>
	<link rel="stylesheet" href="/css/bootstrap.css" />
	<link rel="stylesheet" href="/js/uploader/webuploader.css" />
</head>
<body>
	<div class="container">
		<div class="page-header">
			webupload 文件上传
		</div>
		<div id="picker">选择文件</div>
		<ul id="list" class="list-group">
		
		
		</ul>
		<div class="btn btn-primary" id="btn">开始上传</div>
	</div>
	
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script src="/js/uploader/webuploader.js"></script>
	<script>
		$(function(){
			var uploader = WebUploader.create({
				swf : '/js/uploader/Uploader.swf', // 文件上传的控件swf路径
				server : '/file/upload', // 设置文件上传的服务器路径
				pick : '#picker', // 设置选择（浏览）文件的按钮
				fileVal : 'file'
			}); 
			
			// 添加文件到文件队列
			uploader.on('fileQueued',function(file) {
				var li = "<li id=" + file.id + " class=\"list-group-item\">" + file.name + "<span style='margin-left:20px'></span></li>" 
				$("#list").append(li);
			});
			
			// 文件上传进度事件
			uploader.on('uploadProgress',function(file, percentage){
				$("#"+ file.id).find("span").text( parseInt(percentage  * 100)+ "%");
			}); 
			
			uploader.on( 'uploadSuccess', function( file ) {
			    $( '#'+file.id ).find('span').text('已上传').addClass("text-success");
			});

			uploader.on( 'uploadError', function( file ) {
			    $( '#'+file.id ).find('span').text('上传出错').addClass("text-danger");
			});

			uploader.on( 'uploadComplete', function( file ) {
			    
			});
			
			$("#btn").click(function(){
				uploader.upload();
				
			})
			
		})
	
	</script>
</body>
</html>