<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
    <!-- 校验输入表单数据的函数  客户端验证 -->
    <script type="text/javascript">
    	//去掉空格
    	function trim(str)
    	{
    		//使用正则表达式去掉字符的前后空格
    		return str.replace(/^\s/,"").replace(/\s*$/,"");
    	}
    	function check(form)
    	{
    		//定义错误标志字符串
    		var errorStr="";
    		//获取表单的4个数据
    		var userName =trim(form.userName.value);
    		var userPassword =trim(form.userPassword.value);
    		var userAge =trim(form.userAge.value);
    		var userTelephone =trim(form.userTelephone.value);
    		var pattern =/^\d{8}$/;
    		//判断用户名是否为空
    		if(userName ==null || userName =="")
    		{
    			errorStr ="用户名不能为空";
    		}
    		else if(userPassword.length >16 || userPassword.length <6)
    		{
    			errorStr ="密码长度必须在6~16之间";
    		}
    		else if(userAge >130 || userAge <0)
    		{
    			errorStr ="年龄必须在0~130之间";
    		}
    		else if(!pattern.test(userTelephone))
    		{
    			errorStr ="电话号码为8位阿拉伯数字组成!";
    		}
    		if(errorStr == "")
    		{
    			return true;
    		}else{
    			alert(errorStr);
    			return false;
    		}
    	}
    </script>
  </head>
  
  <body>
    <center>
    请输入注册信息...
    <hr>
    <s:form action="register" method="post" onSubmit="return check(this);">
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
    				<s:submit value="提交"/>
    			</td>
    		</tr>
    	</table>
    </s:form>
    </center>
  </body>
</html>
