package javaweb13SmartUpload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

public class DownServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileName=request.getParameter("fileName");
        
        //Get��ʽ���ñ���ĸ�ʽ
        fileName=new String(fileName.getBytes("ISO-8859-1"),"GB2312");
        
        //��һ������������
        SmartUpload smart=new SmartUpload();
        
        smart.initialize(super.getServletConfig(), request, response);//��ʼ��
        
        //������:�������������Ϊ(ʼ���Ը�������ʽ�����ļ�)
        smart.setContentDisposition(null);
        
        try {
            
            //���Ĳ�:���ļ��µ�ָ����λ��
            smart.downloadFile("/images/"+fileName);
            
            System.out.println("ok");
        } catch (Exception e) {
            // TODO: handle exception
        }
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
		
	}

}
