<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>Session</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%!int number = 0;
		synchronized void countPeople(){
			number++;
		}
	%>
	<%
    	if(session.isNew())
    	{
    		countPeople();
    		String str = String.valueOf(number);
        	session.setAttribute("count", str);
    	}   	
    %>
  </head>
  
  <body>
    <p>您时第<%=(String)session.getAttribute("count") %>个访问本站的人</p>
  </body>
</html>
