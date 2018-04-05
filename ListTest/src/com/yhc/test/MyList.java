package com.yhc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年9月13日 上午11:44:37
 */
public class MyList {

	@Test
	public void testUser(){
		List<User> userList = new ArrayList<User>();
		User user = null;
		for(int i=1;i<=5;i++){
			user = new User();
			user.setName("u"+i);
			user.setAge(i);
			userList.add(user);
		}
		System.out.println(userList.toString());
		user = new User("u2", 2);
		if(userList.contains(user)){
			userList.remove(user);
			System.out.println(userList.toString());
		};
		
	}
}
