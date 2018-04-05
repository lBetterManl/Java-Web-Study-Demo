package com.yhc.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionSupport;
import com.yhc.entity.User;

public class Register extends ActionSupport {
	private String userName;  
	 private String password;
	
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
	 //读取配置文件  
	Configuration cfg = new Configuration().configure();
	ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);    
    private Session session = null; 
    public String execute() {
    	  session = factory.openSession();  
          //开启事务  
          session.beginTransaction();            
          User user = new User(); 
          user.setUsername(getUserName());  
          user.setPassword(getPassword());           
          session.save(user);  
          //提交事务  
          session.getTransaction().commit(); 
          session.close();
		return SUCCESS;
	}
}
