<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�б�ѡ��ʵ��</title>
    <sx:head/>
  </head> 
  <body>
  <!-- value��action���� -->
    <s:url id="getList" value="getList"/>
    1.��ȡ�������˵�list
    <hr>
   	 ѡ����ϲ�������γ��У�
   	 <br>
   	<sx:autocompleter name="a1" href="%{getList}"></sx:autocompleter>
   	<hr> 
   	2.����autoComplete ="false"
    <hr>
   	 ѡ����ϲ�������γ��У�
   	 <br>
   	<sx:autocompleter name="a1" href="%{getList}" autoComplete="false"></sx:autocompleter>
   	<hr> 
   	3.����showDownArrow ="false"
    <hr>
   	 ѡ����ϲ�������γ��У�
   	 <br>
   	<sx:autocompleter name="a1" href="%{getList}" showDownArrow ="false"></sx:autocompleter>
   	<hr> 
   	4.����searchType="substring"
    <hr>
   	 ѡ����ϲ�������γ��У�
   	 <br>
   	<sx:autocompleter name="a1" href="%{getList}" searchType="substring"></sx:autocompleter>
   	<hr>  	
  </body>
</html>
