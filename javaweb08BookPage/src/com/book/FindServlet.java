package com.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currPage = 1;//��ǰҳ��
		if(request.getParameter("page")!=null){	//�жϴ���ҳ���Ƿ���Ч
			currPage = Integer.parseInt(request.getParameter("page"));//�Ե�ǰҳ�븳ֵ
		}
		BookDao dao = new BookDao();//ʵ����BookDao
		List<BookBean> list = dao.find(currPage);//��ѯ����ͼ����Ϣ
		request.setAttribute("list", list);//��list����request��
		int pages;//��ҳ��
		int count = dao.findCount();//��ѯ�ܼ�¼��
		if(count % BookBean.PAGE_SIZE == 0){	//������ҳ��
			pages= count / BookBean.PAGE_SIZE;//����ҳ����ֵ
		}else{
			pages = count / BookBean.PAGE_SIZE + 1;//����ҳ����ֵ
		}
		StringBuffer sb = new StringBuffer();//ʵ����Stringuffer
		for(int i=1;i<=pages;i++){//ͨ��ѭ�������ҳ����

			if(i == currPage){//�ж��Ƿ�Ϊ��ǰҳ
				sb.append("[" + i+ "]");//������ҳ������
			}else{
				//������ҳ������
				sb.append("<a href='FindServlet?page=" + i + "'>" + i+ "</a>");
			}
			sb.append(" ");
	
		}
		request.setAttribute("bar", sb.toString());//����ҳ���������ַ������õ�request��
		//ת����booklist.jspҳ��
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
