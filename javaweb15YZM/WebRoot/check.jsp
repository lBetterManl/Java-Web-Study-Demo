<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");//解决参数乱码问题
	String name = request.getParameter("UserName");
	String password = request.getParameter("PWD");
	String message;
	if(request.getParameter("vcode").equals(request.getParameter("yanzheng"))){
		message = "您输入的验证码不正确！";
	}else if(name.equals("yhc")&&password.equals("123")){
		message = "可以登录系统！";	
	}else{
		message = "用户名或密码错误！";
	}	
%>
<script type="text/javascript">
	alert("<%=message%>")
	window.location.href='index.jsp';
</script>
  
