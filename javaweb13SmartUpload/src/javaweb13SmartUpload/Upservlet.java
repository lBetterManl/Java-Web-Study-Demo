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

		 //设置编码格式
        request.setCharacterEncoding("GB2312");
        response.setCharacterEncoding("GB2312");
        
        //第一步:新建一个对象
        SmartUpload smart=new SmartUpload();
        
        //第二步:初始化
        smart.initialize(super.getServletConfig(), request, response);
        
        //第三步:设置上传文件的类型
        smart.setAllowedFilesList("jpg,png,html,pdf,txt,zip");
        
        try {
            //第三步:上传文件
            smart.upload();
            
            //第四步：保存文件
            //smart.save("/imges");
            //对文件进行重命名
            Files fs= smart.getFiles();//得到所有的文件
            
            for (int i = 0; i <fs.getCount(); i++) {//对文件个数进行循环
                
                File f=fs.getFile(i);
                
                if (f.isMissing()==false) {//判断文件是否存在
                    
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
