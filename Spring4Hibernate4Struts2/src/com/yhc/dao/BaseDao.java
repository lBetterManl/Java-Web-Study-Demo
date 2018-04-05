package com.yhc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	//使用 xml配置bean时需要
	/*
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
