<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>addCheck.jsp</title>
</head>

<body>
	<center>
		<h3>已添加学生信息</h3>
		<hr>
		<%
			String SID = request.getParameter("SID");
			byte a[] = SID.getBytes("ISO-8859-1");
			SID = new String(a, "UTF-8");
			String SName = request.getParameter("SName");
			byte b[] = SName.getBytes("ISO-8859-1");
			SName = new String(b, "UTF-8");
			String SSex = request.getParameter("SSex");
			byte c[] = SSex.getBytes("ISO-8859-1");
			SSex = new String(c, "UTF-8");
			String SAge = request.getParameter("SAge");
			byte d[] = SAge.getBytes("ISO-8859-1");
			SAge = new String(d, "UTF-8");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databasename=student";
			String user = "sa";
			String password = "123";
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			String sql = "insert into stuinfo values('" + SID + "','" + SName+ "','" + SSex + "','" + SAge + "')";
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		%>
		<h3>已更改学生信息</h3>
		<hr>
		<%
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url1 = "jdbc:sqlserver://localhost:1433;databasename=student";
			String user1 = "sa";
			String password1 = "123";
			Connection conn1 = DriverManager.getConnection(url1, user1,password1);
			Statement stmt1 = conn1.createStatement();
			String sql1 = "update stuinfo set SAge=12 where SAge=18";
			stmt1.executeUpdate(sql1);
			stmt1.close();
			conn1.close();
		%>
		<h3>已删除学生信息</h3>
		<hr>
		<table align="center" border="1">
    	<tr>
    		<td width="87" align="center">学号</td>
    		<td width="87" align="center">姓名</td>
    		<td width="87" align="center">性别</td>
    		<td width="87" align="center">年龄</td>
    	</tr>
		<%
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url2 = "jdbc:sqlserver://localhost:1433;databasename=student";
			String user2 = "sa";
			String password2 = "123";
			Connection conn2 = DriverManager.getConnection(url2, user2,password2);
			Statement stmt2 = conn2.createStatement();
			String sql2 = "delete from stuinfo where SSex='女'";
			stmt2.executeUpdate(sql2);
			stmt2.close();
			conn2.close();
		%>
		<h3>经过以上操作后，数据库中有以下记录</h3>
		<hr>
		<%
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url3 = "jdbc:sqlserver://localhost:1433;databasename=student";
			String user3 = "sa";
			String password3 = "123";
			Connection conn3 = DriverManager.getConnection(url3, user3,password3);
			Statement stmt3 = conn3.createStatement();
			String sql3 = "select * from stuinfo";
			ResultSet rs=stmt3.executeQuery(sql3);
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
			stmt3.close();
			conn3.close();
		 %>
		</table>
	</center>
</body>
</html>
