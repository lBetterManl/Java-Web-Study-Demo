package com.imooc.page.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.page.Constant;
import com.imooc.page.model.Pager;
import com.imooc.page.model.Student;
import com.imooc.page.service.StudentService;
import com.imooc.page.service.SublistStudentServiceImpl;
import com.imooc.page.util.StringUtil;

public class SublistServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3658128508633145268L;
	
	private StudentService studentService = new SublistStudentServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����request��Ĳ���
		String stuName = request.getParameter("stuName"); //ѧ������
		
		// ��ȡѧ���Ա�
		int gender = Constant.DEFAULT_GENDER;
		String genderStr = request.getParameter("gender");
		if(genderStr!=null && !"".equals(genderStr.trim())){
			gender = Integer.parseInt(genderStr);
		}
		
		// У��pageNum��������Ϸ���
		String pageNumStr = request.getParameter("pageNum"); 
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			request.setAttribute("errorMsg", "�����������");
			request.getRequestDispatcher("sublistStudent.jsp").forward(request, response);
			return;
		}
		
		int pageNum = Constant.DEFAULT_PAGE_NUM; //��ʾ�ڼ�ҳ����
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // ÿҳ��ʾ��������¼
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		// ��װ��ѯ����
		Student searchModel = new Student(); 
		searchModel.setStuName(stuName);
		searchModel.setGender(gender);
		
		//����service ��ȡ��ѯ���
		Pager<Student> result = studentService.findStudent(searchModel, 
																pageNum, pageSize);
		
		// ���ؽ����ҳ��
		request.setAttribute("result", result);
		request.setAttribute("stuName", stuName);
		request.setAttribute("gender", gender);
		
		request.getRequestDispatcher("sublistStudent.jsp").forward(request, response);
	}

}



