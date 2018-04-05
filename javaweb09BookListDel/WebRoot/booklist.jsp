<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.book.BookBean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>目录显示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function CheckAll(elementsA, elementsB){
			for(i=0;i<elementsA.length;i++){
				elementsA[i].checked = true;
			}
			if(elementsB.checked==false){
				for(j=0;j<elementsA.length;j++){
					elementsA[j].checked = false;
				}
			}
		}
		
		function Del(delid){
			var flag = false;
			for(i=0;i<delid.length;i++){
				if(delid[i].checked){
					flag = true;
				}
			}
			
			if(!flag){
				alert("请选择需要删除的记录！");
				return false;
			}
			if(confirm("确定删除？")){
				return true;
			}
			else{
				return false;
			}
		}
	</script>

  </head>
  
  <body>
    <div width="98%" align="center">
    	<h2>所有图书信息</h2>
    </div>
    <form action="DelServlet" method="post" name="frm">
    	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="666666">
    	<tr align="center">
    			<td bgcolor="#FFF">ID</td>
    			<td bgcolor="#FFF">书名</td>
    			<td bgcolor="#FFF">作者</td>
    			<td bgcolor="#FFF">价格</td>
    			<td bgcolor="#FFF">删除</td>
    		</tr>
    	<%
    	List<BookBean> list = (List<BookBean>)request.getAttribute("list");
    	if(list==null || list.size()<1){
    		out.print("<tr><td bgcolor='#FFF' colspan='6'>没有任何图书信息！</td></tr>");
    	}else{
    		for(BookBean book:list){
    	%>
    		<tr align="center">
    			<td bgcolor="#FFF"><%=book.getBid() %></td>
    			<td bgcolor="#FFF"><%=book.getBname() %></td>
    			<td bgcolor="#FFF"><%=book.getAuthor() %></td>
    			<td bgcolor="#FFF"><%=book.getPrice() %></td>
    			<td bgcolor="#FFF"><input name="delid" type="checkbox" value="<%=book.getBid() %>"/></td>
    		</tr>
    	
    	<%		
    		}
    	}
    	%>
    	
    	</table>
    	<footer>
    		<input name="checkbox" type="checkbox" onclick="CheckAll(frm.delid,frm.checkbox)">[全选/反选]
    		&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="删除" onclick="return Del(delid)"/>
    	</footer>
    </form>
  </body>
</html>
