<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index.jsp</title>
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
  //注意SQL Server的驱动名和URL,不同版本可能不一样
  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  String url="jdbc:sqlserver://localhost:1433;databasename=student";
  String user="sa";
  String password="123";
  Connection con=DriverManager.getConnection(url, user, password);
  Statement stmt=con.createStatement();
  String sql="select * from stuinfo";
  ResultSet rs=stmt.executeQuery(sql);
  while(rs.next()){
     %>
    <tr>
    	<td><%=rs.getString("SID")%></td>
    	<td><%=rs.getString("SName")%></td>
    	<td><%=rs.getString("SSex")%></td>
    	<td><%=rs.getString("SAge")%></td>  	
    </tr>
    <%
    }
    rs.close();
    stmt.close();
    con.close();
     %>
    </table>
  </body>
</html>