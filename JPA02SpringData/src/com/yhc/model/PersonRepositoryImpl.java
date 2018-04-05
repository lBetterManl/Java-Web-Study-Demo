package com.yhc.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月8日 下午6:06:45
 */
public class PersonRepositoryImpl implements PersonDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void test() {
		Person person = entityManager.find(Person.class, 11);
		System.out.println("--->"+person);		
	}
	
	
}
