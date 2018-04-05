package com.test;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.Department;
import com.bean.Employee;

public class HibernateTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
												.applySettings(configuration.getProperties())
												.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void destory(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	/*
	 * 查询部分属性,投影查询
	 */
	@Test
	public void testFieldQuery(){
		
		String hql = "SELECT e.email, e.salary, e.dept FROM Employee e WHERE e.dept = :dept";
		Query query = session.createQuery(hql);
		
		Department dept = new Department();
		dept.setId(80);
		List<Object[]> result = query.setEntity("dept", dept)
				                     .list();
		
		for(Object [] objs: result){
			System.out.println(Arrays.asList(objs));
		}
	}
	
	
	/*
	 * 在xml中配置查询语句
	 */
	@Test
	public void testNamedQuery(){
		Query query = session.getNamedQuery("salaryEmps");
		
		List<Employee> news = query.setInteger("minId", 2)
				.setInteger("maxId", 4)
				.list();
		
		System.out.println(news);
	}
	
	
	/*
	 * 分页查询
	 */
	@Test
	public void testPage(){
		
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		
		int pageNo = 22;
		int pageSize = 5;
		
		List<Employee> emps = 
								query.setFirstResult((pageNo - 1) * pageSize)
								     .setMaxResults(pageSize)
								     .list();
		System.out.println(emps);
		
	}
	
}
