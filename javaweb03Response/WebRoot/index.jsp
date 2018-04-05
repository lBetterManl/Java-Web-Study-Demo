<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>HTTP响应</title>
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
    <center>
    	<h2>自动更新响应</h2>
    	<%
    		//设置每隔5秒自动刷新
    		response.setIntHeader("Refresh", 5);
    		//获取当前时间
    		Calendar calendar = new GregorianCalendar();
    		String am_pm;
    		int hour = calendar.get(Calendar.HOUR);
    		int minute = calendar.get(Calendar.MINUTE);
    		int second = calendar.get(Calendar.SECOND);
    		if(calendar.get(Calendar.AM_PM) == 0)
    		{
    			am_pm = "AM";
    		}
    		else
    		{
    			am_pm = "PM";
    		}
    		String CT = hour + ":" + minute + ":" + second + " "+ am_pm;
    		out.println("当前时间时： " + CT + "\n");
    	%>
    </center>
  </body>
</html>
