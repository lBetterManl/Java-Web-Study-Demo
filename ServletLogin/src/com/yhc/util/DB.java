package com.yhc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/servlet_login";
	private final static String user = "root";
	private final static String password = "root";
	
	private static DB db = null;
	
	public static DB getInstance() {
		if(db == null)
			db = new DB();
		return db;
	}
	
	public Connection getConn(){
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			System.out.println("");
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("");
		}
		return conn;
	}
	
	public Statement createStmt(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.out.println("");
		}
		return stmt;
	}
	
	public PreparedStatement getPreStmt(Connection conn,String sql) {
		PreparedStatement preStmt = null;
		try {
			preStmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			System.out.println("");
		}
		return preStmt;
	}
	
	public ResultSet getRs(Statement stmt,String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("ResultSet");
		}
		return rs;
	}
	
	public void closeConn(Connection conn) {
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("ghj");
			}
		}
	}
	
	public void closeStmt(Statement stmt) {
		if(stmt != null){
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.println("");
			}
		}
	}
	
	public void closeRs(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("ResultSet");
			}
		}
	}
}
