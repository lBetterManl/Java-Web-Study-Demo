<%@page import="cn.student.stu.Stu"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>selectDeleteStu.jsp</title>
 
  </head>
  
  <body bgcolor="CCCFFF">
    <br><br><br><br><br><br>
    <center>
    <h2>删除学生信息</h2>
    <%
    ArrayList list = (ArrayList)session.getAttribute("list");
     %>
     <form action="deleteStu" method="post">
     <p>请选择要删除学生的学号:</p>
     <select name="sID">
     	<%
     	for(int i=0;i<list.size();i++){
     		Stu st = (Stu)list.get(i);
     	%>
     	<option value="<%=st.getsID()%>">
     		<%=st.getsID() %>
     	</option>
     	<%
     	}
     	 %>
     </select>
     <P>
     	<input type="submit" value="确定"/>&nbsp;
     	<input type="button" value="返回" onClick="javascripe:history.go(-1)"/>
     </P>
     </form>
    </center>
  </body>
</html>
