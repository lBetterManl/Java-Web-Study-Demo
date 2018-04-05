<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>  
    <%  
        String msg = (String)(request.getAttribute("msg")==null?"":request.getAttribute("msg"));  
    %>  
    <script type="text/javascript">  
        function show(){  
            if('<%=msg%>'!=''){  
                alert('<%=msg%>');  
            }  
        }  
    </script>  
</head>  
<body style="text-align: center" onload="show();">  
    <form action="login.do" method="post">  
        <table border="1">  
            <tr>  
                <td align="center" colspan="2">  
                    <h3>用户登录</h3>  
                </td>  
            </tr>  
            <tr>  
                <td align="right">  
                    用户名  
                </td>  
                <td align="left">  
                    <input type="text" id="userName" name="userName">  
                </td>  
            </tr>  
            <tr>  
                <td align="right">  
                    密 码  
                </td>  
                <td align="left">  
                    <input type="password" id="password" name="password">  
                </td>  
            </tr>  
            <tr>  
                <td align="center" colspan="2">  
                    <input type="submit" value="登录">  
                       
                    <input type="reset" value="重置">  
                </td>  
            </tr>  
        </table>  
    </form>  
  </body>  
</html>