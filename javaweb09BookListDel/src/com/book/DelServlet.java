package com.book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelServlet extends HttpServlet {

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
			String sql = "delete from t_book where bid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			String BID[] = request.getParameterValues("delid"); //获取要删除的图书编号
			if(BID.length>0){
				for(int i=0;i<BID.length;i++){
					ps.setInt(1, Integer.parseInt(BID[i]));
					ps.addBatch();//添加批处理命令
				}
			}
			ps.executeBatch();
			ps.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("FindServlet");

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
