package com.yhc.hibernate.test;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yhc.hibernate.service.BookService;
import com.yhc.hibernate.service.CashierService;

public class SpringHibernateTest {

	private ApplicationContext ctx = null;
	private BookService bookService = null;
	
	private  CashierService cashierService  = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookService = ctx.getBean(BookService.class);
		cashierService = ctx.getBean(CashierService.class);
	}
	
	/**
	 * 购买多本书
	 */
	@Test
	public void testCashierService(){
		cashierService.checkout("aa", Arrays.asList("1001","1002"));
	}
	
	
	/**
	 * 购买一本书：用户 aa 购买一本书，书号为 1001
	 */
	@Test
	public void testBookService(){
		bookService.purchase("aa", "1001");
	}
	
	/**
	 * 测试数据源
	 * @throws SQLException
	 */
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
