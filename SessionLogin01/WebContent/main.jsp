<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>  
<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>  
</head>  
    <%  
        response.setHeader("Pragma","No-cache");   
        response.setHeader("Cache-Control","No-cache");   
        response.setDateHeader("Expires", -1);   
        response.setHeader("Cache-Control", "No-store");  
        String userName = "";  
        userName = (String)(session.getAttribute("userName")==null?"":session.getAttribute("userName"));  
    %>  
    <script type="text/javascript">  
        var int;   
        var userMsg = '';  
        var i =0;  
        function checkUserOnline(){  
            $.ajax({  
                type:"post",  
                url:"getUserMsg.do",  
                dataType : "text",  
                success:function(data){userMsg = data;},  
                error:function(){  
                    alert("获取用户信息失败！");  
                    clearInterval(int);  
                    reLogin();  
                }  
            });  
            if(userMsg=='null'||userMsg==''){  
                return;  
            }  
            else{  
                alert(userMsg);  
                clearInterval(int);  
                reLogin();  
            }  
        }  
        function reLogin(){  
            window.location = "reLogin.do";  
        }  
  
        function checkLogin(){  
            int = setInterval("checkUserOnline()",500);  
        }  
    </script>  
    <body onload="checkLogin()">  
        <%  
            if(!"".equals(userName)){  
                out.print("登陆成功！<br/>用户名：<span id='userName'>"+userName+"</span><br/><input type='button' value='重新登陆' onclick='reLogin();'/>");  
            }  
        %>  
    </body>  
</html>