package com.yhc.action;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private String userName;
	private String userPassword;
	private int userAge;
	private String userTelephone;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public String execute() {
		return SUCCESS;
	}
	
}
