package com.imooc.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SmartUploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�����ϴ��ļ�����·��
		String filePath = getServletContext().getRealPath("/") + "images";
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		
		SmartUpload su = new SmartUpload();
		//��ʼ������
		su.initialize(getServletConfig(), req, resp);
		//�����ϴ��ļ���С
		su.setMaxFileSize(1024*1024*10);
		//���������ļ��Ĵ�С
		su.setTotalMaxFileSize(1024*1024*100);
		//���������ϴ��ļ�����
		su.setAllowedFilesList("txt,jpg,gif");
		String result = "�ϴ��ɹ���";
		//���ý�ֹ�ϴ����ļ�����
			try {
				su.setDeniedFilesList("rar,jsp,js");
				//�ϴ��ļ�
				su.upload();
				int count = su.save(filePath);
				System.out.println("�ϴ��ɹ�" +  count + "���ļ���");
			} catch (Exception e) {
				result = "�ϴ�ʧ�ܣ�";
				if(e.getMessage().indexOf("1015") != -1){
					result = "�ϴ�ʧ��:�ϴ��ļ����Ͳ���ȷ��";
				}else if (e.getMessage().indexOf("1010") != -1){
					result = "�ϴ�ʧ��:�ϴ��ļ����Ͳ���ȷ��";
				}else if (e.getMessage().indexOf("1105") != -1){
					result = "�ϴ�ʧ��:�ϴ��ļ���С���������ϴ������ֵ��";
				}else if (e.getMessage().indexOf("1110") != -1){
					result = "�ϴ�ʧ��:�ϴ��ļ��ܴ�С���������ϴ��ܴ�С�����ֵ��";
				}
				e.printStackTrace();
			} 
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("jsp/02.jsp").forward(req, resp);
	}

}
