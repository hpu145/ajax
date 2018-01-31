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
		<div id="res"></div>
		
	</div>
	
	<script src="/js/jquery-1.11.3.min.js"></script>
	<script src="/js/uploader/webuploader.js"></script>
	<script>
		$(function(){
			var uploader = WebUploader.create({
				swf : '/js/uploader/Uploader.swf', // 文件上传的控件swf路径
				server : '/file/upload', // 设置文件上传的服务器路径
				pick : '#picker', // 设置选择（浏览）文件的按钮
				fileVal : 'file',
				auto : true,
				accept : {
				    title: 'Images',
				    extensions: 'gif,jpg,jpeg,bmp,png',
				    mimeTypes: 'image/*'
				}
				
			}); 
			

			uploader.on('uploadSuccess', function(file, resp) {
			    $( '#'+file.id ).find('span').text('已上传').addClass("text-success");
			   	
			    var html = "<img>"
				$(html).attr("src",resp.data).appendTo($("#res"));
			    
			    /* $("#res").html("");
				uploader.makeThumb(file,function(error, src){
					if(error) {
						alert("当前文件不支持预览")
						return;
					} 
					var html = "<img>"
					$(html).attr("src",src).appendTo($("#res"));
				},200, 200); */
			});

			
			
		});
	
	</script>
</body>
</html>
