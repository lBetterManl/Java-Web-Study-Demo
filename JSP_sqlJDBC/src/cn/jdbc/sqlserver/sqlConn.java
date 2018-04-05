package cn.jdbc.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class sqlConn {
	private Connection conn=null;
	private Statement stmt=null;
	private   ResultSet rs=null;
	public Connection getConn() {
		return conn;
	}
	public Statement getStmt() {
		return stmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void conNet() throws Exception {	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://localhost:1433;databasename=student";
		String user="sa";
		String password="123";
		conn=DriverManager.getConnection(url, user, password);
		stmt=conn.createStatement();
		String sql="select * from stuinfo";
		rs=stmt.executeQuery(sql);
	}
	public void myClose() throws Exception {
		conn.close();
		stmt.close();
		rs.close();	
	}
}
