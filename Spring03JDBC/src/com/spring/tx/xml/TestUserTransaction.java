package com.spring.tx.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserTransaction {

	private ApplicationContext ctx = null;
	private UserDao userDao = null;
	
	private UserService userService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		userDao = ctx.getBean(UserDao.class);
		
		userService = ctx.getBean(UserService.class);
	
	}
	
	@Test
	public void testTransaction() {
		System.out.println(userService.findUser(2));

	}

}
