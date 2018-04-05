package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	//添加事务注解
	//1.使用 propagation 指定事务的船舶行为，即当前的事务方法被另一个事务方法调用时
	//如何使用事务，默认取值为REQUIRED
	//REQUIRES_NEW 事务自己的事务，调用的事务方法的事务被挂起
	//2.使用 isolation 指定事务idea隔离级别，最常用的取值为 READ_CoMMITED
	//3.默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚。也可以通过对应的属性设置,通常默认
	@Transactional(propagation=Propagation.REQUIRED, 
			isolation=Isolation.READ_COMMITTED)
	@Override
	public String findUser(Integer id) {
		String address = userDao.findUserById(4);
		return address;
	}

}
