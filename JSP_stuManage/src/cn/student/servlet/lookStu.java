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

public class lookStu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			stuBean db = new stuBean();
			ResultSet rs = db.selectStu();	//stuBean()
			//获取session对象
			HttpSession session = req.getSession();
			//声明一个集合对象保存数据
			ArrayList<Stu> list = new ArrayList<Stu>();
			while(rs.next()){
				//实例化学生对象用于保存记录
				Stu st = new Stu();
				st.setsID(rs.getString("SID"));
				st.setsName(rs.getString("SName"));
				st.setsSex(rs.getString("SSex"));
				st.setsAge(rs.getString("SAge"));
				//把用数据的学生对象保存在集合中
				list.add(st);
				//把集合对象保存在session中，以便于在lookStu.jsp中获取保存的数据
				session.setAttribute("list", list);
			}
			rs.close();
			resp.sendRedirect("lookStu.jsp");
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
