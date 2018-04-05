<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>成功页面</title>
  </head> 
 <body>
    评论如下：
  <hr>
    评论标题：<s:property value="title"/>
  <br>
    评论内容：  <s:property value="content"/>
  </body>
</html>
