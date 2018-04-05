<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.book.BookBean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>分页查询</title>
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
  <table>
    <% //获取图书信息集合
    	List<BookBean> list = (List<BookBean>) request.getAttribute("list");
    	if(list==null || list.size()<1){	//	判断集合是否有效
    		out.print("<tr><td bgcolor='#FFF' colspan='5'>没有任何图书信息！</td></tr>");
    	}else{
    		for(BookBean book : list) {	//遍历图书集合中的数据
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
    <div width="98%" align="center" style="padding-top:10px;">
    	<%=request.getAttribute("bar") %><!-- 用于输出分页导航条 -->
    </div>
  </body>
</html>
