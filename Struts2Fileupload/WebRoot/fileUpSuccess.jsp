<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>文件上传成功</title>
  </head>
  
  <body>
    <h3>文件上传成功</h3>
    <hr>
    文件标题：<s:property value="title"/><br>
  <s:property value="uploadFileName"/><br>
  <s:property value="uploadContentType"/><br>
  <!-- save是在项目目录下创建的文件夹，用来保存上传的文件，上传后文件将被保存在
  	Tomcat/webapps/Struts2Fileupload/save 目录下；在开发工具中使
  	用时需在Struts2Fileupload/中新建一个文件夹save -->
  	<img alt="上传文件" src="<s:property value="'../save/'+uploadFileName"/>"/>
  	<br>
  </body>
</html>
