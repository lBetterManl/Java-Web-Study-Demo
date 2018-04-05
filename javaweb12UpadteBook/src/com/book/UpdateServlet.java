package com.book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bid = Integer.valueOf(request.getParameter("bid"));
		int bookPrice = Integer.valueOf(request.getParameter("bookPrice"));
		try {
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�������ע�ᵽ����������
			String url = "jdbc:mysql://localhost:3306/db_book";// ���ݿ������ַ���
			String username = "root"; // ���ݿ��û���
			String password = "root"; // ���ݿ�����
			// ����Connection����
			Connection conn = DriverManager.getConnection(url, username,
					password);
			String sql = "update t_book set price=? where bid=?";// ����SQL���
			PreparedStatement ps = conn.prepareStatement(sql);// ��ȡPreparedStatement
			ps.setInt(1, bookPrice); // ��SQL����еĵ�һ��������ֵ
			ps.setInt(2, bid); // ��SQL����еĵڶ���������ֵ
			ps.executeUpdate(); // ִ�и��²���
			ps.close(); // �ر�PreparedStatement
			conn.close(); // �ر�Connection
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("FindServlet"); // �ض���FindServlet
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
