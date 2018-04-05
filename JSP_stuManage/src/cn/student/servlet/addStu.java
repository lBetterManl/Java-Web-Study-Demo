package cn.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.student.bean.stuBean;

public class addStu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//代码转换，防止中文乱码
		String sID = request.getParameter("SID");
		byte[] b1 = sID.getBytes("ISO-8859-1");
		sID = new String(b1,"UTF-8");
		
		String sName = request.getParameter("SName");
		byte[] b2 = sName.getBytes("ISO-8859-1");
		sName = new String(b2,"UTF-8");
		
		String sSex = request.getParameter("SSex");
		byte[] b3 = sSex.getBytes("ISO-8859-1");
		sSex = new String(b3,"UTF-8");
		
		String sAge = request.getParameter("SAge");
		byte[] b4 = sAge.getBytes("ISO-8859-1");
		sAge = new String(b4,"UTF-8");
		
		stuBean db = new stuBean();
		
		if (db.addStu(sID, sName, sSex, sAge)) {
			response.sendRedirect("addSuccess.jsp");
		}else{
			response.sendRedirect("addStu.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
