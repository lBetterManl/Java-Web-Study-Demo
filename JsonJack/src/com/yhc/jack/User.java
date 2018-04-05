package com.yhc.jack;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月4日 下午3:05:07
 */
public class User {

	private String name;
	private String pwd;
	
	
	
	public User() {
		super();
	}
	
	
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
