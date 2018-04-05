<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>列表选项实例</title>
    <sx:head/>
  </head> 
  <body>
  <!-- value是action名字 -->
    <s:url id="getList" value="getList"/>
    1.获取服务器端的list
    <hr>
   	 选择你喜欢的旅游城市：
   	 <br>
   	<sx:autocompleter name="a1" href="%{getList}"></sx:autocompleter>
   	<hr> 
   	2.设置autoComplete ="false"
    <hr>
   	 选择你喜欢的旅游城市：
   	 <br>
   	<sx:autocompleter name="a1" href="%{getList}" autoComplete="false"></sx:autocompleter>
   	<hr> 
   	3.设置showDownArrow ="false"
    <hr>
   	 选择你喜欢的旅游城市：
   	 <br>
   	<sx:autocompleter name="a1" href="%{getList}" showDownArrow ="false"></sx:autocompleter>
   	<hr> 
   	4.设置searchType="substring"
    <hr>
   	 选择你喜欢的旅游城市：
   	 <br>
   	<sx:autocompleter name="a1" href="%{getList}" searchType="substring"></sx:autocompleter>
   	<hr>  	
  </body>
</html>
