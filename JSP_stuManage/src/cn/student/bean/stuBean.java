package cn.student.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class stuBean {

	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=gbk";
	private String user = "root";
	private String password = "root";
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	//完成数据库连接
	public Statement getStatement() {
		try {
			Class.forName(getDriverName());
			con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			return con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			message("无法完成数据库的连接或无法返回容器，请检查getStatement()方法！！！");
			return null;
		}	
	}
	
	
	//添加学生信息方法，注意sql语句写法
	public boolean addStu(String sID,String sName,String sSex,String sAge) {
		try {
			String sql = "insert into stuinfo"+"(SID,SName,SSex,SAge)"+"values("+"'"+sID+"'"+","+"'"+sName+"'"+","+"'"+sSex+"'"+","+"'"+sAge+"'"+")";
			stmt = getStatement();
			int row = stmt.executeUpdate(sql);
			if (row==1) {
				stmt.close();
				con.close();
				return true;
			}else{
				stmt.close();
				con.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			message("无法添加学生信息，请检查addStu()方法！！！");
			return false;
		}
	}
	
	//查询所有学生信息，并返回rs
	public ResultSet selectStu() {
		
		try {
			String sql="select * from stuinfo";
			stmt=getStatement();
			return stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			message("无法查询学生信息，请检查selectStu()方法！！！");
			return null;
		}		
	}
	
	//查询要修改的学生信息
	public ResultSet selectUpdateStu(String sID){	
		try {
			String sql="select * from stuinfo where SID='"+sID+"'";
			stmt=getStatement();
			return stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			message("无法查询到要修改学生的信息，请检查输入的学号！！！");
			return null;
		}
	}
	
	//修改学生信息
	public boolean updateStu(String sID,String sName,String sSex,String sAge) {
		try {
			String sql = "update stuinfo set SName='"+sName+"',SSex='"+sSex+"',SAge='"+sAge+"' where SID='"+sID+"'";
			stmt=getStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			message("无法修改学生的信息请检查updateStu()方法！！！");
			return false;
		}
	}
	
	//查询要删除的学生信息
	public ResultSet lookDelStu() {
		try {
			String sql = "select * from stuinfo";
			stmt = getStatement();
			return stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			message("无法查询到要删除学生的信息，请检查lookDelStu()方法！！！");
			return null;
		}		
	}
	
	//删除学生信息
	public boolean delStu(String sID) {	
		try {
			String sql = "delete from stuinfo where SID='"+sID+"'";
			stmt = getStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			message("无法删除学生的信息，请检查delStu()方法！！！");
			return false;
		}	
	}
	
	//一个带参数的提示框，用于排除错误
	private void message(String msg) {

		int type = JOptionPane.YES_NO_OPTION;
		String title="信息提示";
		JOptionPane.showMessageDialog(null, msg, title, type);
		
	}
	
	
}
