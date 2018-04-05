<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addStu.jsp' starting page</title>
  </head>
  
  <body>
    <br><br>
    <center>
    <form action="addCheck.jsp" method="post">
    <h2>添加学生信息</h2>
    <hr>
   	<table>
   	<tr>
   	<td>学号：</td>
   	<td><input type="text" name="SID"/></td>
   	</tr>
   	<tr>
   	<td>姓名：</td>
   	<td><input type="text" name="SName"/></td>
   	</tr>
   	<tr>
   	<td>性别：</td>
   	<td><input type="text" name="SSex"/></td>
   	</tr>
   	<tr>
   	<td>年龄：</td>
   	<td><input type="text" name="SAge"/></td>
   	</tr>
   	<tr align="center">
   	<td colspan="2">
   	<input name="sure" type="submit" value="提交"> 
   	&nbsp;&nbsp;&nbsp;&nbsp;
   	<input name="clear" type="reset" value="取消">
   	</td>
   	</tr>
   	</table>
    </form>
    </center>
  </body>
</html>
