<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录注册</title>
  </head>
  
  <body>
    <table width="360" align="center">
    //Action动态方法调用
    	<form action="loginReg!execute">
    	<tr>
    		<td>用户名：</td>
    		<td><input type="text" name="userName" size="26"/></td>
    	</tr>
    	<tr>
    		<td>密&nbsp;&nbsp;码：</td>
    		<td><input type="password" name="password" size="28"/></td>
    	</tr>
    	<tr>
    		<td><input type="submit" value="登录"/></td>
    		<td><input type="submit" value="注册" onclick="register();"/></td>
    	</tr>
    	</form>
    </table>
    <script type="text/javascript">
    	function register(){
    		//获取页面的第一个表单
    		targetForm = document.forms[0];
    		//动态修改表单的action属性
    		targetForm.action ="loginReg!regist";
    	
    	}
    </script>
  </body>
</html>
