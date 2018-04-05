package com.yhc.service.impl;

import com.yhc.dao.UserDao;
import com.yhc.dao.impl.UserDaoImpl;
import com.yhc.model.User;
import com.yhc.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
