package com.yhc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginRegisterAction extends ActionSupport {
	private String userName;
	private String password;
	private String msg;	//设置返回消息
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	//Action包含的注册控制逻辑
	public String regist() throws Exception{
		ActionContext.getContext().getSession().put("userName", getUserName());
		setMsg("恭喜你，"+userName+"，注册成功！");
		return SUCCESS;
	}
	//Action默认包含的控制逻辑
	public String execute() throws Exception{
		if(getUserName().equals("yhc") && getPassword().equals("123")){
			ActionContext.getContext().getSession().put("userName", getUserName());
			setMsg("你单击的是【登录】！"+"你的登录名为"+userName+"，登录成功！");
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
}
