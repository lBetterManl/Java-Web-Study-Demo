<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.book.BookBean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>显示信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#666">
    	<tr>
    		<th bgcolor="#FFF">ID</th>
    		<th bgcolor="#FFF">图书</th>
    		<th bgcolor="#FFF">作者</th>
    		<th bgcolor="#FFF">价格</th>
    	</tr>
    	
    	<%
    		List<BookBean> list = (List<BookBean>)request.getAttribute("list");
    		if(list==null || list.size()<1){
    			out.print("<tr><td bgcolor='#FFF' colspan='5'>没有任何图书信息！</td></tr>");
    		}else{
    			for(BookBean book:list){
    	%>
    	
    	<tr align="center">
    		<td bgcolor="#FFF"><%=book.getBid() %></td>
    		<td bgcolor="#FFF"><%=book.getBname() %></td>
    		<td bgcolor="#FFF"><%=book.getAuthor() %></td>
    		<td bgcolor="#FFF"><%=book.getPrice() %></td>
    	</tr>
    	
    	<%			
    			}
    		}
    	%>
    	
    </table>
  </body>
</html>
