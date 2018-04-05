package com.yhc.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhc.hibernate.dao.BookDao;
import com.yhc.hibernate.service.BookService;
/**
 * 服务层（业务层） Service
 * @author YHC
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	/**
	 * 买一本书
	 * Spring Hibernate s事务的流程
	 * 1.在方法开始之前
	 * ①.获取Session
	 * ②.把Session和当前线程绑定，这样就可以在Dao中使用SesisonFactory的
	 * getCurrentSession() 方法来获取Session了
	 * ③.开启事务
	 * 
	 * 2.若方法正常结束，即没有出现异常，则
	 * ①.提交事务
	 * ②.使和当前线程绑定的Session 解除绑定
	 * ③.关闭Session
	 * 
	 * 3.若方法出现异常，则：
	 * ①.回滚事务
	 * ②.使和当前线程绑定的Session 解除绑定
	 * ③.关闭Session
	 */
	@Override
	public void purchase(String username, String isbn) {
		
		int price = bookDao.findBookPriceByIsbn(isbn);
		bookDao.updateBookStock(isbn);
		bookDao.updateUserAccount(username, price);
	}

}
