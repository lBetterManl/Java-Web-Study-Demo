package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.UserMapper;
import com.model.User;
import com.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		List<User> findAllUser = userMapper.findAllUser();
		return findAllUser;
	}

}
