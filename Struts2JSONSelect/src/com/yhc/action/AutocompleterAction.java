package com.yhc.action;

import com.opensymphony.xwork2.ActionSupport;

public class AutocompleterAction extends ActionSupport {
	private String a1;

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}
	
	public String execute() {
		return SUCCESS;
	}
}
