package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;

public class TestBean {
	@Test
	public void test1(){
		ApplicationContext acContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) acContext.getBean("user");
		user.sayHello(user.getName());
	}
	
}
