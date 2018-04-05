<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户信息表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <div style="margin: 0 auto;">
    <table style="text-align: center;margin: 0 auto;">
    	<tr>
    		<th width="80px">用户ID</th>
    		<th width="80px">用户名</th>
    		<th width="80px">密码</th>
    		<th width="80px">更改密码</th>
    		<th width="80px">删除</th>
    	</tr>
    	<c:forEach items="${userList }" var="user">
    		<tr>
    			<td>${user.id }</td>
    			<td>${user.name }</td>
    			<td>${user.password }</td>
    			<td><form action="UpdateUser" method="post">
    				<input type="hidden" name="uId" value="${user.id }">
    				<input type="text" name="uPassword" size="30">
    				<input type="submit" value="修改">
    			</form></td>
    			<td><form action="DeleteUser" method="post">
    				<input type="hidden" name="Id" value="${user.id }">
    				<input type="submit" value="删除">
    			</form></td>
    		</tr>
    	</c:forEach>
    </table>
  </div>
  </body>
</html>
