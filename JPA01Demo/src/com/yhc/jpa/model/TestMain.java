package com.yhc.jpa.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月7日 下午10:02:03
 */
public class TestMain {

	public static void main(String[] args) {

		// 1.创建EntityManagerFactory
		String persistenceUnitName = "JPA01Demo";
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(persistenceUnitName);

		// 2.创建EntityManager,类似Hibernate 的SessionFactory
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//4.进行持久化操作
		Customer customer = new Customer();
		customer.setAge(23);
		customer.setEmail("yhc8023tm@foxmail.com");
		customer.setLastName("男神");
		customer.setCreatedTime(new Date());
		customer.setBirth(new Date());
		
		entityManager.persist(customer);
		
		//5.提交事务
		transaction.commit();
		
		//6.关闭EntityManager
		entityManager.close();
		
		//7.关闭EntityManagerFactory
		entityManagerFactory.close();

	}

}
