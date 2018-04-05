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
		int currPage = 1;//当前页码
		if(request.getParameter("page")!=null){	//判断传递页码是否有效
			currPage = Integer.parseInt(request.getParameter("page"));//对当前页码赋值
		}
		BookDao dao = new BookDao();//实例化BookDao
		List<BookBean> list = dao.find(currPage);//查询所有图书信息
		request.setAttribute("list", list);//将list方法request中
		int pages;//总页数
		int count = dao.findCount();//查询总记录数
		if(count % BookBean.PAGE_SIZE == 0){	//计算总页数
			pages= count / BookBean.PAGE_SIZE;//对总页数赋值
		}else{
			pages = count / BookBean.PAGE_SIZE + 1;//对总页数赋值
		}
		StringBuffer sb = new StringBuffer();//实例化Stringuffer
		for(int i=1;i<=pages;i++){//通过循环构造分页导航

			if(i == currPage){//判断是否为当前页
				sb.append("[" + i+ "]");//构建分页当行条
			}else{
				//构建分页导航条
				sb.append("<a href='FindServlet?page=" + i + "'>" + i+ "</a>");
			}
			sb.append(" ");
	
		}
		request.setAttribute("bar", sb.toString());//将分页导航条的字符串放置到request中
		//转发到booklist.jsp页面
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
