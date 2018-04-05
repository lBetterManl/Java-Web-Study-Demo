package com.spring.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private UserDao userDao = null;
	
	private UserService userService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = ctx.getBean(UserDao.class);
		
		userService = ctx.getBean(UserService.class);
	
	}
	
	@Test
	public void testUserService(){
		System.out.println(userService.findUser(5));
	}
	
	@Test
	public void testFindUserById() {
		System.out.println(userDao.findUserById(3));
	}

}
