package cn.student.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.student.bean.stuBean;
import cn.student.stu.Stu;

public class selectDeleteStu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			stuBean db = new stuBean();
			ResultSet rs = db.lookDelStu( );
			HttpSession session = req.getSession();
			ArrayList<Stu> list = new ArrayList<Stu>();
			while (rs.next()) {
				Stu st = new Stu();
				st.setsID(rs.getString("SID"));
				list.add(st);
				session.setAttribute("list", list);
				
			}
			rs.close();
			resp.sendRedirect("selectDeleteStu.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
