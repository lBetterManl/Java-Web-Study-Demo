<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//检查kaptcha验证码是否正确
	response.setContentType("text/html;charset=utf-8");
	String k = (String)session.getAttribute("KAPTCHA_SESSION_KEY");
	String str = request.getParameter("r");
	if(k.equals(str)){
		out.println("验证码正确！");
	}else{
		out.println("验证失败！！！");
	}
	out.println(k+"---"+str);
%>