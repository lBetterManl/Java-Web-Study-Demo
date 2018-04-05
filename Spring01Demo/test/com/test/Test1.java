package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;


public class Test1 {
	
	@Test
	public void testBean() {
		@SuppressWarnings("resource")
		ApplicationContext acContext = new ClassPathXmlApplicationContext("classpath:applicationContext.XML");
		User user = (User) acContext.getBean("user");
		if(acContext.containsBean("admin")){
			System.out.println("有货！");
		}else{
			System.out.println("无货！");
		}
		System.out.println(user);
		System.out.println(acContext.getType("user"));
		
	}
}
