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

public class UpdateUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.valueOf(request.getParameter("uId"));
		String password = request.getParameter("uPassword");
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			User user = (User)session.get(User.class, id);
			user.setPassword(password);
			//session.update(user);
			session.flush();
			transaction.commit();
			System.out.println("更改成功！");
			
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			System.out.println("更改失败");
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
