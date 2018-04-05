<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ssm</title>
    
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
  <h1>${sessionScope.userName }</h1>
   <table border="1">
		<tbody>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>年龄</th>
				<th>地址</th>
				<th>电话</th>
			</tr>
			<c:if test="${!empty allUser }">
				<c:forEach items="${allUser}" var="user">
					<tr>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.userPassword }</td>
						<td>${user.userSex }</td>
						<td>${user.userAge }</td>
						<td>${user.userAddress }</td>
						<td>${user.userTel }</td>		
					</tr>				
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<a href="user/findAllUser?pageNum=${pageNum-1 }">上一页</a>
	<a href="user/findAllUser?pageNum=${pageNum+1 }">下一页</a>
  </body>
</html>
