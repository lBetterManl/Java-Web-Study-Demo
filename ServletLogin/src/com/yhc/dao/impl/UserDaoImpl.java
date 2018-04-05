package com.yhc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yhc.dao.UserDao;
import com.yhc.model.User;
import com.yhc.util.DB;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(User user) {
		DB db = DB.getInstance();
		Connection conn = db.getConn();
		
		User userTemp = new User();
		
		try {
			System.out.println("输入的用户信息："+user);
			String sql = "select * from tb_user where username='"+user.getUsername()+"' and pwd='"+user.getPwd()+"'";
			Statement stmt =  conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				userTemp.setId(rs.getInt("id"));
				userTemp.setUsername(rs.getString("username"));
				userTemp.setPwd(rs.getString("pwd"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			db.closeConn(conn);
		}
		System.out.println("查询到的用户信息："+userTemp);
		return userTemp;
	}

}
