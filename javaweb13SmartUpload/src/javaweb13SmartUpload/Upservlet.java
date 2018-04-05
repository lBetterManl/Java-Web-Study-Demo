package javaweb13SmartUpload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

public class Upservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 //���ñ����ʽ
        request.setCharacterEncoding("GB2312");
        response.setCharacterEncoding("GB2312");
        
        //��һ��:�½�һ������
        SmartUpload smart=new SmartUpload();
        
        //�ڶ���:��ʼ��
        smart.initialize(super.getServletConfig(), request, response);
        
        //������:�����ϴ��ļ�������
        smart.setAllowedFilesList("jpg,png,html,pdf,txt,zip");
        
        try {
            //������:�ϴ��ļ�
            smart.upload();
            
            //���Ĳ��������ļ�
            //smart.save("/imges");
            //���ļ�����������
            Files fs= smart.getFiles();//�õ����е��ļ�
            
            for (int i = 0; i <fs.getCount(); i++) {//���ļ���������ѭ��
                
                File f=fs.getFile(i);
                
                if (f.isMissing()==false) {//�ж��ļ��Ƿ����
                    
                    f.saveAs("/images/"+System.currentTimeMillis()+f.getFileName());
                }
                
            }
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
