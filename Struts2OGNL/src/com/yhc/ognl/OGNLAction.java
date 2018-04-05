package com.yhc.ognl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OGNLAction extends ActionSupport {
	private String nu;
	private String name;
	private String sex;
	private String age;
	public String getNu() {
		return nu;
	}
	public void setNu(String nu) {
		this.nu = nu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String execute() throws Exception {
		//获取request,并添加信息
		HttpServletRequest request =ServletActionContext.getRequest();
		request.setAttribute("name", getName());
		//获取session，并添加信息
		Map<String, Object> session =ActionContext.getContext().getSession();
		session.put("name", getName());
		//获取application，并添加信息
		Map<String, Object> application =ActionContext.getContext().getApplication();
		application.put("name", getName());
		return SUCCESS;
	}
}
