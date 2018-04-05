<%@page import="java.sql.ResultSet"%>
<%@page import="cn.jdbc.sqlserver.sqlConn"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'sqlConn.jsp' starting page</title>
  </head>
  
  <body>
   <h3 align="center">JDBC访问SQL Server数据库</h3>
    <table align="center" border="1">
    <tr>
    	<td width="87" align="center">学号</td>
    	<td width="87" align="center">姓名</td>
    	<td width="87" align="center">性别</td>
    	<td width="87" align="center">年龄</td>
    </tr>
    <%
  sqlConn con=new sqlConn();
  con.conNet();
  ResultSet re=con.getRs();
  while(re.next()){
  %>
    <tr>
    	<td><%=re.getString("SID")%></td>
    	<td><%=re.getString("SName")%></td>
    	<td><%=re.getString("SSex")%></td>
    	<td><%=re.getString("SAge")%></td>  	
    </tr>
    <%
    }
    con.myClose();
     %>
    </table>
  </body>
</html>
