<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@page import="java.io.File"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�ļ�����</title>
    
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
     <%
        String url=super.getServletContext().getRealPath("/")+"images";
        
        File f=new File(url);//�½�һ������
        
        File[] files=f.listFiles();//�õ�����Ŀ¼�µ����е��ļ�
        
        for(File file:files){
            
            out.print("<a href='DownServlet?fileName="+file.getName()+"'>"+file.getName()+"</a><br>");
        }
     %>
  </body>
</html>
