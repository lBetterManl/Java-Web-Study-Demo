<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>验证码</title>
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
    <form action="check.jsp" name="form1" method="post">
    	用户名：<input name="UserName" type="text"/><br><br>
    	密    码：<input name="PWD" type="password"/><br><br>
    	验证码：<input name="yanzheng" type="text" size="8"/>
    	<%
    		int intmethod = (int)(((Math.random())*11)-1);
    		int intmethod2 = (int)(((Math.random())*11)-1);
    		int intmethod3 = (int)(((Math.random())*11)-1);
    		int intmethod4 = (int)(((Math.random())*11)-1);
    		String intsum = intmethod+""+intmethod2+intmethod3+intmethod4;//将得到的随机数进行连接
    	%>
    	<input type="hidden" name="vcode" value="<%=intsum%>"/>
    	<img src="num/<%=intmethod%>.gif"> <img src="num/<%=intmethod2%>.gif">
    	<img src="num/<%=intmethod3%>.gif"> <img src="num/<%=intmethod4%>.gif">
    	<br><br>
    	<input name="Submit" type="button" value="登录" onclick="mycheck()">
    	&nbsp;<input name="Submit2" type="reset" value="重置">
    </form>

  </body>
</html>
