package com.yhc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	//�ļ�����
	private String title;
	//�ϴ��ļ�����
	private File upload;
	//�ϴ��ļ���(�̶�)
	private String uploadFileName; 
	//�ϴ��ļ�����
	private String uploadContentType;
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	//��ȡ��struts.xml�ļ������õ��ļ�����·��
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
		//�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
		FileOutputStream fos =new FileOutputStream(getSavePath()+"\\"+getUploadFileName());
		//�������������
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
