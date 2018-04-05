package com.yhc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginRegisterAction extends ActionSupport {
	private String userName;
	private String password;
	private String msg;	//���÷�����Ϣ
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
	//Action������ע������߼�
	public String regist() throws Exception{
		ActionContext.getContext().getSession().put("userName", getUserName());
		setMsg("��ϲ�㣬"+userName+"��ע��ɹ���");
		return SUCCESS;
	}
	//ActionĬ�ϰ����Ŀ����߼�
	public String execute() throws Exception{
		if(getUserName().equals("yhc") && getPassword().equals("123")){
			ActionContext.getContext().getSession().put("userName", getUserName());
			setMsg("�㵥�����ǡ���¼����"+"��ĵ�¼��Ϊ"+userName+"����¼�ɹ���");
			return SUCCESS;
		}
		else{
			return INPUT;
		}
	}
}
