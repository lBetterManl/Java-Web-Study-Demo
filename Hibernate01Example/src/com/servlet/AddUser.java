package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.User;
import com.util.HibernateUtil;

public class AddUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		User user = new User();
		user.setName("女神");
		user.setPassword("YYYYY");
		Session session = null;
		Transaction transaction = null;
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			PrintWriter out = response.getWriter();
			out.println("<script>confirm('数据添加成功！');</script>");
			
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
			System.out.println("添加失败！");
		} finally{
			HibernateUtil.closeSession();
		}
		response.sendRedirect("QueryUser");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
