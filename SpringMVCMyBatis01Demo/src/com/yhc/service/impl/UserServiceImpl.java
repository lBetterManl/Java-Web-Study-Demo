package com.yhc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhc.entity.User;
import com.yhc.mapper.UserMapper;
import com.yhc.pagehelper.Page;
import com.yhc.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public int deleteById(Integer userId) {
		int i = userMapper.deleteById(userId);
		return i;
	}

	@Override
	public int insert(User user) {
		int i = userMapper.insert(user);
		return i;
	}

	@Override
	public User selectById(Integer userId) {
		User user = userMapper.selectById(userId);
		return user;
	}

	@Override
	public int update(User user) {
		int i = userMapper.update(user);
		return i;
	}

	@Override
	public List<User> findAllUser(Page page) {
		List<User> allUser = userMapper.findAllUser(page);
		return allUser;
	}

	@Override
	public User login(User user) {
		User userSuccess = userMapper.login(user);
		return userSuccess;
	}

}
