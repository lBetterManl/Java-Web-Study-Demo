package com.yhc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	//文件标题
	private String title;
	//上传文件对象
	private File upload;
	//上传文件名(固定)
	private String uploadFileName; 
	//上传文件类型
	private String uploadContentType;
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	//获取在struts.xml文件中配置的文件保存路径
	private String savePath;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getSavePath() throws Exception{
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public String execute() throws Exception {
		//以服务器的文件保存地址和原文件名建立上传文件输出流
		FileOutputStream fos =new FileOutputStream(getSavePath()+"\\"+getUploadFileName());
		//定义输出流对象
		FileInputStream fis =new FileInputStream(getUpload());
		byte[] buffer =new byte[1024];
		int len =0;
		while((len =fis.read(buffer))>0){
			fos.write(buffer, 0, len);
		}
		fos.close();
		fis.close();
		return SUCCESS;
	}
}
