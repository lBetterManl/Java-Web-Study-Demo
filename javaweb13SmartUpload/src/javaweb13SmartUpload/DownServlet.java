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
        
        //Get方式设置编码的格式
        fileName=new String(fileName.getBytes("ISO-8859-1"),"GB2312");
        
        //第一步：创建对象
        SmartUpload smart=new SmartUpload();
        
        smart.initialize(super.getServletConfig(), request, response);//初始化
        
        //第三步:设置浏览器的行为(始终以附件的形式处理文件)
        smart.setContentDisposition(null);
        
        try {
            
            //第四部:将文件下到指定的位置
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
