package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.entity.User;
import com.util.HibernateUtil;

public class QueryUser extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Session session =null;
		String hql = "";
		List<User> userList = new ArrayList<User>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			hql = "from User user";
			Query query = session.createQuery(hql);
			userList = query.list();
			session.getTransaction().commit();
			System.out.println("查询成功！");
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			System.out.println("查询失败！");
			e.printStackTrace();
		} finally{
			HibernateUtil.closeSession();
		}
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
