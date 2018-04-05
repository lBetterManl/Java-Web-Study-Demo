package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.User;
import com.util.HibernateUtil;

public class DeleteUser extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("Id"));
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			User user = (User)session.get(User.class, id);
			session.delete(user);
			transaction.commit();
			System.out.println("É¾³ý³É¹¦£¡");
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			System.out.println("É¾³ýÊ§°Ü£¡");
			e.printStackTrace();
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
