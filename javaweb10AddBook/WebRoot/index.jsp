<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加首页</title>
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
    <form action="addBook.jsp" method="post" onsubmit="return check(this)">
    	<ul>
    		<li>图书：<input type="text" name="bname"></li>
    		<li>作者：<input type="text" name="author"></li>
    		<li>价格：<input type="text" name="price"></li>
    		<li><input type="submit" value="添加"></li>
    	</ul>
    </form>
  </body>
</html>
