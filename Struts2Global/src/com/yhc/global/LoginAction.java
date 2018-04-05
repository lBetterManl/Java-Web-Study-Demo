package com.yhc.global;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String name;
	private String password;
	//用于定义标题信息
	private String tip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String execute() {
		if(getName().equals("yhc") && getPassword().equals("123")){
			ActionContext.getContext().getSession().put("tip", getName());
			return SUCCESS;
		}
		else{
			return ERROR;
		}	
	}
	
}
