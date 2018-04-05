<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ pagecontentType="text/html;charset=gb2312" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   	
    <title>注册成功</title>
  </head>
  
  <body>
    	<h1>${name }</h1>
    	<hr>
    	获取action属性：<s:property value="name"/><br>
    	获取request属性：<s:property value="#request.name"/><br>
    	获取session属性：<s:property value="#session.name"/><br>
    	获取application属性：<s:property value="#application.name"/><br>
    	<hr>
  </body>
</html>
