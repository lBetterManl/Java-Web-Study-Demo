<%@page import="cn.student.stu.Stu"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'lookStu.jsp' starting page</title>
    
  </head>
  
  <body bgcolor="CCCFFF">
    <br><br><br><br>
    <center>
    	<%
    	//获取list中的数据，即集合中的数据
    	ArrayList list = (ArrayList)session.getAttribute("list");
    	 %>
    	<h3> 你要查询的学生数据表中共有
    	 <font size="5" color="red"><%=list.size()%></font>
    	 人
    	 </h3>
    	 <table border="1" bgcolor="CCCEEE" width="600">
    	 	<tr bgcolor="CCCCCC" align="center">
    	 	<th>学号</th>
    	 	<th>姓名</th>
    	 	<th>性别</th>
    	 	<th>年龄</th>
    	 	</tr>
    	 	<%
    	 	for(int i=0;i<list.size();i++){
    	 		Stu st = (Stu)list.get(i);
    	 	%>
    	 	<tr align="center">
    	 		<td><%=st.getsID() %></td>
    	 		<td><%=st.getsName() %></td>
    	 		<td><%=st.getsSex() %></td>
    	 		<td><%=st.getsAge() %></td>
    	 	</tr>
    	 	<%
    	 	}
    	 	 %>
    	 </table>
    </center>
  </body>
</html>
