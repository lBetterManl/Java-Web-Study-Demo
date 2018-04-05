<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="book" class="com.book.BookBean"></jsp:useBean>
<jsp:setProperty property="*" name="book"/>
<%
try {
	Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动，注册驱动到驱动管理
	//数据库连接字符串
	String url = "jdbc:mysql://localhost:3306/db_book";
	String username = "root";	//数据库用户名
	String password = "root";//数据库密码
	//创建Connection连接
	Connection conn = DriverManager.getConnection(url,username,password);
	String sql = "insert into t_book(bname,author,price) values(?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, book.getBname());
	ps.setString(2, book.getAuthor());
	ps.setDouble(3, book.getPrice());
	int row = ps.executeUpdate();
	if(row>0){
		out.print("成功添加了"+ row +"条数据");
	}
	ps.close();
	conn.close();
} catch (Exception e) {
	// TODO Auto-generated catch block
	out.print("图书添加失败！");
	e.printStackTrace();
}
%>
<br><a href="index.jsp">返回</a>
