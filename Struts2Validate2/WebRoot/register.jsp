<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>注册页面</title>
  </head>
  
  <body>
    <center>
    请输入注册信息...
    <hr>
    <s:form action="register" method="post">
    	<table border="1">
    		<tr>
    			<td>
    				<s:textfield name="userName" label="姓名" size="16"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<s:password name="userPassword" label="密码" size="18"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<s:password name="ruserPassword" label="再次输入密码" size="18"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<s:textfield name="userAge" label="年龄" size="16"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<s:textfield name="userTelephone" label="电话" size="16"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<s:textfield name="userEmail" label="邮箱" size="16"/>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<s:submit value="提交"/>
    			</td>
    		</tr>
    	</table>
    </s:form>
    </center>
  </body>
</html>
