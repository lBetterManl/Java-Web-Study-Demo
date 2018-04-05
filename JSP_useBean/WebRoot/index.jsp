<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
    <form method="post" action="">
    用户名：<input type="text" name="userName"/><br>
    密    码：<input type="password" name="password"/><br>
    <input type="submit" value="提交"/>
    <input type="reset" value="清除"/>
    </form>
    <jsp:useBean id="login" class="JavaBean.Login"/>
    <jsp:setProperty property="*" name="login"/>
    <hr>
    <p>用户名：</p>
    <jsp:getProperty property="userName" name="login"/>
    <p>密    码：</p>
    <jsp:getProperty property="password" name="login"/>
  </body>
</html>
