<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文件上传</title>
  </head> 
  <body>
  文件上传
  <hr>
  <!-- enctype设置为multipart/form-data,该属性用来设置
  	浏览器采用二进制的方式来处理表单数据，上传文件时需要使用该属性 -->  	
  	<form action="upLoad" enctype="multipart/form-data" method="post">
  		文件标题：<input type="text" name="title"/>
  		选择文件：<input type="file" name="upload"/>
  		<input type="submit" value="上传"/>
  	</form>
  </body>
</html>
