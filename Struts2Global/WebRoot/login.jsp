<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
  </head>
  
  <body>
    <s:form action="checkLogin" method="post">
    	<s:textfield name="name" key="loginName" size="20"/><br>
    	<s:password name="password" key="loginPassword" size="22"/><br>
    	<s:submit key="loginSubmit"/>
    </s:form>
  </body>
</html>
