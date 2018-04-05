<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>登录成功</title>
  </head>
  
  <body>
    <hr>
    <s:text name="loginName"/>:<s:property value="name"/><br>
    <s:text name="loginPassword"/>:<s:property value="password"/><br>
  </body>
</html>
