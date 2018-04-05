package service.impl;

import org.junit.Assert;
import org.junit.Test;

import service.UsersDao;
import entity.Users;

public class TestUsersDaoImpl {

	//测试用户登录
	@Test
	public void testUsersLogin() {
		
		Users u = new Users(1,"yhc","123");
		UsersDao udao = new UsersDaoImpl();
		Assert.assertEquals(true, udao.usersLogin(u));//测试是否为期望类型
	}
}
