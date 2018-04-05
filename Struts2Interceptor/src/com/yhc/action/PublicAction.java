package com.yhc.action;

import com.opensymphony.xwork2.ActionSupport;

public class PublicAction extends ActionSupport {

	private String title;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String execute() {
		return SUCCESS;
	}

}
