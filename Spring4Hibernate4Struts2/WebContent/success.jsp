<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.yhc.entity.Department"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>成功</h1>
<table>
	<c:forEach items="${departments }" var="dpt">
		<tr>
			<td>${dpt.id }</td>
			<td>${dpt.departmentName }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>