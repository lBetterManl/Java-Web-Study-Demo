package cn.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.student.bean.stuBean;

public class updateStu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//代码转换，防止中文乱码
				String sID = req.getParameter("sID");
				byte[] b1 = sID.getBytes("ISO-8859-1");
				sID = new String(b1,"UTF-8");
				
				String sName = req.getParameter("sName");
				byte[] b2 = sName.getBytes("ISO-8859-1");
				sName = new String(b2,"UTF-8");
				
				String sSex = req.getParameter("sSex");
				byte[] b3 = sSex.getBytes("ISO-8859-1");
				sSex = new String(b3,"UTF-8");
				
				String sAge = req.getParameter("sAge");
				byte[] b4 = sAge.getBytes("ISO-8859-1");
				sAge = new String(b4,"UTF-8");
		
		stuBean db = new stuBean();
		
		if (db.updateStu(sID, sName, sSex, sAge)) {
			resp.sendRedirect("updateSuccess.jsp");
		}else{
			resp.sendRedirect("updateStu.jsp");
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}


}
