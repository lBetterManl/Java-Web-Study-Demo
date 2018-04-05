package com.spring.tx.xml;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	
	//没注解要添加
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public String findUser(Integer id) {
		String address = userDao.findUserById(4);
		return address;
	}

}
