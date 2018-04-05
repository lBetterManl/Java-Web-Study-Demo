<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet验证码</title>
<script type="text/javascript">
	function reloadCode(){
		var time = new Date().getTime();
		document.getElementById("imageCode").src="<%=request.getContextPath()%>/servlet/ImageServlet?d="+time;
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="get">
		验证码：<input type="text" name="checkcode"><br>
		<img alt="验证码" id="imageCode" src="<%=request.getContextPath()%>/servlet/ImageServlet"/>
		<a href="javascript:reloadCode();">看不清楚</a>
		<input type="submit" value="登录">
	</form>
</body>
</html>