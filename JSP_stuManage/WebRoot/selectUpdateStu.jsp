<%@page import="cn.student.stu.Stu"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>selectUpdateStu.jsp</title>
  
  </head>
  
  <body bgcolor="CCCFFF">
    <center>
    	<br><br><br>
    	<h3>请修改学生信息！</h3>
    	<form action="updateStu" method="post">
    	<table border="1" width="600">
    	<%
    	ArrayList list = (ArrayList)session.getAttribute("list");
    	for(int i=0;i<list.size();i++){
    		Stu st = (Stu)list.get(i);
    	%>
    	
    	<tr>
    		<td>学号：</td>
    		<td><input type="text" name="sID" value="<%=st.getsID()%>"/></td>
    	</tr>
    	<tr>
    		<td>姓名：</td>
    		<td><input type="text" name="sName" value="<%=st.getsName()%>"/></td>
    	</tr>
    	<tr>
    		<td>性别：</td>
    		<td><input type="text" name="sSex" value="<%=st.getsSex()%>"/></td>
    	</tr>
    	<tr>
    		<td>年龄：</td>
    		<td><input type="text" name="sAge" value="<%=st.getsAge()%>"/></td>
    	</tr>
    	<tr align="center">
    	<td colspan="2">
    	<input name="sure" type="submit" value="修  改"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;
    	<input name="clear" type="reset" value="取  消">
    	</td>
    	</tr>
    	<%
    	}
    	 %>
    	
    	</table>
    	</form>
    </center>
  </body>
</html>
