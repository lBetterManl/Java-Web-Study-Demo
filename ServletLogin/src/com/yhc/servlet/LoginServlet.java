package com.yhc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yhc.model.User;
import com.yhc.service.UserService;
import com.yhc.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService userService = new UserServiceImpl();
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPwd(request.getParameter("pwd"));
		User model = userService.login(user);
		String result = "登录失败";
		if(model.getUsername()!=null && model.getUsername()!=null){
			result = "登陆成功";
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
