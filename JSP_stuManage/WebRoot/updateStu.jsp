<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>updateStu.jsp</title>

  </head>
  
  <body bgcolor="CCCFFF">
    <br><br><br><br>
    <center>
    	<form action="selectUpdateStu" method="post">
    	<p>请输入要修改学生的学号:
    	<input type="text" name="SID"/>
    	</p>
    	<p>
    	<input type="submit" valus="确定"/>&nbsp;
    	<input type="button" value="返回" onClick="javascript:hostory.go(-1)"/>
    	</p>
    	</form>
    </center>
  </body>
</html>
