package com.yhc.mapper;

import java.util.List;

import com.yhc.entity.User;
import com.yhc.pagehelper.Page;

public interface UserMapper {
	
	int insert(User user);
	
    int deleteById(Integer userId);

    int update(User user);

    User selectById(Integer userId);

    List<User> findAllUser(Page page);
    
    User login(User user);
}