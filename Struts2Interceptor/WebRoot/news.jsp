<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>自定义拦截器</title>
  </head> 
  <body>
    请发表你的评论！
    <hr>
    <s:form action="public" method="post">
    	<s:textfield name="title" label="评论标题" maxLength="36"/><br>
    	<s:textarea name="content" cols="36" rows="6" label="评论内容"/><br>
    	<s:submit value="提交"/>
    </s:form>
  </body>
</html>
