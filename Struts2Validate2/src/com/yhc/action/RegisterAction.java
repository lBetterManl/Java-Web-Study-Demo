package com.yhc.action;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private String userName;
	private String userPassword;
	private String ruserPassword;
	private Integer userAge;
	private Integer userTelephone;
	private String userEmail;
	
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

	public String getRuserPassword() {
		return ruserPassword;
	}

	public void setRuserPassword(String ruserPassword) {
		this.ruserPassword = ruserPassword;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Integer getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(Integer userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String execute() throws Exception{
		return SUCCESS;
	}
}
