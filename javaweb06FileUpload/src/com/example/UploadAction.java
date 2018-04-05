package com.example;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6498047960854005893L;
	private File upload;	//和上传文件名一致
    private String uploadContentType;
    private String uploadFileName;
    private String result;
   
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("文件名: "+this.uploadFileName);
		String path = ServletActionContext.getServletContext().getRealPath("images");
		File file = new File(path);
		if(!file.exists())
		{
			file.mkdir();	//创建目录
		}
		
		FileUtils.copyFile(upload, new File(file,uploadFileName));
		System.out.println("文件类型: "+this.uploadContentType);
		result =  "上传成功";
		return SUCCESS;
	}

	
    
}
