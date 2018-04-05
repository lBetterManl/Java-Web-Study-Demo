<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.book.BookBean"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>显示图书列表</title>
<style type="text/css">
td,th {
	padding: 5px;
}
</style>
</head>
<body>
	<div width="98%" align="center">
		<h2>所有图书信息</h2>
	</div>
	<table width="98%" border="0" align="center" cellpadding="0"
		cellspacing="1" bgcolor="#666666">
		<tr>
			<th bgcolor="#FFFFFF">ID</th>
			<th bgcolor="#FFFFFF">图书名称</th>
			<th bgcolor="#FFFFFF">价格</th>
			<th bgcolor="#FFFFFF">作者</th>
		</tr>
		<%
			// 获取图书信息集合
			List<BookBean> list = (List<BookBean>) request.getAttribute("list");
			// 判断集合是否有效
			if (list == null || list.size() < 1) {
				out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有任何图书信息！</td></tr>");
			} else {
				// 遍历图书集合中的数据
				for (BookBean book : list) {
		%>
		<tr align="center">
			<td bgcolor="#FFFFFF" ><%=book.getBid()%></td>
			<td bgcolor="#FFFFFF"><%=book.getBname()%></td>
			<td bgcolor="#FFFFFF"><%=book.getPrice()%></td>
			<td bgcolor="#FFFFFF"><%=book.getAuthor()%></td>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>