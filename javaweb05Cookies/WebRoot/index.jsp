<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>JSP Cookies处理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%
   // 为 first_name 和 last_name设置cookie      
   Cookie firstName = new Cookie("first_name",
 			  request.getParameter("first_name"));
   Cookie lastName = new Cookie("last_name",
			  request.getParameter("last_name"));
   // 设置cookie过期时间为24小时。
   firstName.setMaxAge(60*60*24); 
   lastName.setMaxAge(60*60*24); 

   // 在响应头部添加cookie
   response.addCookie( firstName );
   response.addCookie( lastName );
%>
  </head>
  
  <body>
    <center>
<h1>Setting Cookies</h1>
</center>
<ul>
<li><p><b>First Name:</b>
   <%= request.getParameter("first_name")%>
</p></li>
<li><p><b>Last  Name:</b>
   <%= request.getParameter("last_name")%>
</p></li>
</ul>
  </body>
</html>
