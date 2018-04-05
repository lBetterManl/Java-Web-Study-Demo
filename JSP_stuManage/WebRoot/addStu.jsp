<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>addStu.jsp</title>

</head>

<body bgcolor="CCCFFF">
	<br><br><br>
	<h3>添加学生信息</h3>
	<form action="addStu" method="post">
		<table border="1" width="230">
		<tr>
			<td>学号:</td>
			<td><input type="text" name="SID"/></td>
		</tr>
		<tr>
			<td>姓名:</td>
			<td><input type="text" name="SName"/></td>
		</tr>
		<tr>
			<td>性别:</td>
			<td><input type="text" name="SSex"/></td>
		</tr>
		<tr>
			<td>年龄:</td>
			<td><input type="text" name="SAge"/></td>
		</tr>
		<tr align="center">
		<td colspan="2">
			<input name="sure" type="submit" value="提交">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重置">
		</td>
		</tr>
		</table>
	</form>
</body>
</html>
