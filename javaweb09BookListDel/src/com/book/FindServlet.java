package com.book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动，注册驱动到驱动管理
				//数据库连接字符串
				String url = "jdbc:mysql://localhost:3306/db_book";
				String username = "root";	//数据库用户名
				String password = "root";//数据库密码
				//创建Connection连接
				Connection conn = DriverManager.getConnection(url,username,password);
				Statement stmt = conn.createStatement();
				String sql = "select * from t_book";
				ResultSet rs = stmt.executeQuery(sql);
				List<BookBean> list = new ArrayList<BookBean>();
				while(rs.next()){
					BookBean book = new BookBean();
					book.setBid(rs.getInt("bid"));
					book.setBname(rs.getString("bname"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getDouble("price"));
					list.add(book);
				}
				request.setAttribute("list", list);
				rs.close();
				stmt.close();
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("booklist.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
