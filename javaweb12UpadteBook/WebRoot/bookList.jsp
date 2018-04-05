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
tr {
	height:30px;
}
</style>
<script type="text/javascript">
	function check(form){
		if(form.bookCount.value == ""){
			alert("请输入更新价格！");
			form.bookCount.focus();
			return false;
		}
		if(isNaN(form.bookCount.value)){
			alert("格式错误！");
			form.bookCount.focus();
			return false;
		}
		return true;;
	}
</script>
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
    <th bgcolor="#FFFFFF">修改价格</th>
  </tr>
  <%
  // 获取图书信息集合
  List<BookBean> list = (List<BookBean>) request.getAttribute("list");
  // 判断集合是否有效
  if (list == null || list.size() < 1) {
	  out.print("<tr><td bgcolor='#FFFFFF' colspan='6'>没有任何图书信息！</td></tr>");
  } else {
	  // 遍历图书集合中的数据
	  for (BookBean book : list) {
  %>
  <tr align="center">
    <td bgcolor="#FFFFFF" ><%=book.getBid()%></td>
    <td bgcolor="#FFFFFF"><%=book.getBname()%></td>
    <td bgcolor="#FFFFFF"><%=book.getPrice()%></td>
    <td bgcolor="#FFFFFF"><%=book.getAuthor()%></td>
    <td bgcolor="#FFFFFF"><form action="UpdateServlet" method="post" onsubmit="return check(this);">
        <input type="hidden" name="bid" value="<%=book.getBid()%>">
        <input type="text" name="bookPrice" size="3">
        <input type="submit" value="修　改">
      </form></td>
  </tr>
  <%
		}
	}
  %>
</table>
</body>
</html>