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
		Connection conn = null;	//���ݿ�����
		try {
			Class.forName("com.mysql.jdbc.Driver");//�������ݿ�������ע����������������
			//���ݿ������ַ���
			String url = "jdbc:mysql://localhost:3306/db_book";
			String username = "root";	//���ݿ��û���
			String password = "root";//���ݿ�����
			//����Connection����
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
	 * ��ҳ��ѯ������Ϣ
	 * @param page ��ǰ�ǵڼ�ҳ
	 * @return
	 */
	public List<BookBean> find(int page){
		List<BookBean> list = new ArrayList<BookBean>();	//����list
		Connection conn = getConnection();//��ȡ���ݿ�����
		//��ҳ��ѯ��SQL���
		String sql = "select * from t_book limit ?,?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);//��ȡPreparedStatement
			ps.setInt(1, (page-1) * BookBean.PAGE_SIZE);//��sql����еĵ�1��������ֵ����ʼ��ѯ��λ��
			ps.setInt(2, BookBean.PAGE_SIZE);//��sql����еĵ�2��������ֵ,ÿҳ��ʾ�ļ�¼��
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				BookBean book = new BookBean();
				book.setBid(rs.getInt("bid"));
				book.setBname(rs.getString("bname"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				list.add(book);
			}
			rs.close();//�ر�ResultSet
			ps.close();//�ر�PreparedStatement
			conn.close();//�ر�Connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int findCount(){
		int count = 0;//�ܼ�¼��
		Connection conn = getConnection();//��ȡ���ݿ�����
		String sql = "select count(*) from t_book";//��ѯ�ܼ�¼����sql���
		try {
			Statement stmt = conn.createStatement();//����statement
			ResultSet rs = stmt.executeQuery(sql);//��ѯ����ȡResultSet
			if(rs.next()){			//�������ƶ����ж��Ƿ���Ч
				count = rs.getInt(1);//�Լ�¼����ֵ
			}
			rs.close();//�ر�ResultSet
			conn.close();//�ر�Connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;//�����ܼ�¼��
	}

}
