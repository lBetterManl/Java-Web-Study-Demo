package com.yhc.service;

import java.util.List;

import com.yhc.entity.User;
import com.yhc.pagehelper.Page;

public interface UserService {

	int deleteById(Integer userId);

    int insert(User user);

    User selectById(Integer userId);

    int update(User user);
    
    List<User> findAllUser(Page page);
    
    User login(User user);
}
