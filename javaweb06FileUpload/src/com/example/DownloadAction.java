package com.example;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{

	private static final long serialVersionUID = 5795432791254825128L;
	private String basePath = ServletActionContext.getServletContext().getRealPath("/images");  
	 private String fileName;  
	      
	      
	    public String execute(){  
	        return "succ";  
	    }  
	      
	    public InputStream getInputStream() throws FileNotFoundException{  
	        return new FileInputStream(new File(basePath, fileName));  
	    }  
	  
	    public String getFileName() throws UnsupportedEncodingException {  
	        return new String(fileName.getBytes(), "ISO-8859-1");  
	    }  
	  
	    public void setFileName(String fileName) {  
	        this.fileName = fileName;  
	    }  
}
