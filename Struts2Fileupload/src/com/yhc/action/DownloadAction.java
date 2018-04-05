package com.yhc.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{
	//指定下载路径
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	//该方法返回一个InputStream类型的输入流，是下载目标文件的入口
	public InputStream getInputStream() throws Exception{
		return ServletActionContext.getServletContext().getResourceAsStream(path);
	}
	public String execute() throws Exception {
		return SUCCESS;
	}
}
