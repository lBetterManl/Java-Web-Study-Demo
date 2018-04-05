package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	public Connection getConnection(){
		Connection conn = null;	//数据库连接
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动，注册驱动到驱动管理
			//数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/db_book";
			String username = "root";	//数据库用户名
			String password = "root";//数据库密码
			//创建Connection连接
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return conn;	
	}
	
	/**
	 * 分页查询所有信息
	 * @param page 当前是第几页
	 * @return
	 */
	public List<BookBean> find(int page){
		List<BookBean> list = new ArrayList<BookBean>();	//创建list
		Connection conn = getConnection();//获取数据库连接
		//分页查询的SQL语句
		String sql = "select * from t_book limit ?,?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);//获取PreparedStatement
			ps.setInt(1, (page-1) * BookBean.PAGE_SIZE);//对sql语句中的第1个参数赋值，开始查询的位置
			ps.setInt(2, BookBean.PAGE_SIZE);//对sql语句中的第2个参数赋值,每页显示的记录数
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				BookBean book = new BookBean();
				book.setBid(rs.getInt("bid"));
				book.setBname(rs.getString("bname"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				list.add(book);
			}
			rs.close();//关闭ResultSet
			ps.close();//关闭PreparedStatement
			conn.close();//关闭Connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int findCount(){
		int count = 0;//总记录数
		Connection conn = getConnection();//获取数据库连接
		String sql = "select count(*) from t_book";//查询总记录数的sql语句
		try {
			Statement stmt = conn.createStatement();//创建statement
			ResultSet rs = stmt.executeQuery(sql);//查询并获取ResultSet
			if(rs.next()){			//光标向后移动，判断是否有效
				count = rs.getInt(1);//对记录数赋值
			}
			rs.close();//关闭ResultSet
			conn.close();//关闭Connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;//返回总记录数
	}

}
