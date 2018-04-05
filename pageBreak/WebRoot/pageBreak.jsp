
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>分页实例</title>

</head>

<body>
	<center>
		分页显示记录内容
		<hr>
		<table border="1">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
			</tr>
			<%
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
				Connection conn = DriverManager.getConnection(url, "root", "root");
				int intPageSize;	//一页显示的记录数
				int intRowCount;	//总记录数
				int intPageCount;	//总页数
				int intPage;	//待显示页码
				String strPage;
				int i;
				intPageSize=2;	//设置一页显示的记录
				strPage = request.getParameter("page");	//取得待显示页码
				if(strPage==null){
				//表明page的参数值为空，此时显示第一页数据
					intPage=1;
				}else{
				//将字符串转换成整型
					intPage = Integer.parseInt(strPage);
					if(intPage<1)
						intPage = 1;
				}
				Statement stmt = conn.createStatement(
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
				String sql = "select * from stuinfo";
				ResultSet rs = stmt.executeQuery(sql);
				rs.last();	//光标指向查询结果集中最后一条记录
				intRowCount = rs.getRow();	//获取记录总数
				intPageCount = (intRowCount + intPageSize - 1) / intPageSize;	//计算总页数
				if(intPage > intPageCount){
					intPage = intPageCount;	//调整待显示的页码
				}
				if(intPageCount > 0){
					//将记录指针定位到待显示页的第一条记录上
					rs.absolute((intPage - 1)*intPageSize + 1);
					//显示数据
					i = 0;
					while(i < intPageSize && !rs.isAfterLast()){
			%>
			<tr>
			<td><%=rs.getString("SID")%></td>
			<td><%=rs.getString("SName")%></td>
			<td><%=rs.getString("SSex")%></td>
			<td><%=rs.getString("SAge")%></td>
			</tr>
			
			<%		rs.next();
					i++;
					}
				}
				
			%>
		</table>
		<hr>
		<div align="center">
		第<%=intPage%>页&nbsp;共<%=intPageCount%>页
		<%
			if(intPage < intPageCount){
		%>
		<a href="pageBreak.jsp?page=<%=intPage + 1%>">下一页</a>
		<%	
			}
			if(intPage > 1){
		%>
		<a href="pageBreak.jsp?page=<%=intPage - 1%>">上一页</a>
		<%
			}
			rs.close();
			stmt.close();
			conn.close();
		 %>
		</div>
	</center>
</body>
</html>
