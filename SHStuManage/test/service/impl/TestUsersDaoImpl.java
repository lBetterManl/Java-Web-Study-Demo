package service.impl;

import org.junit.Assert;
import org.junit.Test;

import service.UsersDao;
import entity.Users;

public class TestUsersDaoImpl {

	//�����û���¼
	@Test
	public void testUsersLogin() {
		
		Users u = new Users(1,"yhc","123");
		UsersDao udao = new UsersDaoImpl();
		Assert.assertEquals(true, udao.usersLogin(u));//�����Ƿ�Ϊ��������
	}
}
