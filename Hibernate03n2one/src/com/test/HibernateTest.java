package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.entity.Customer;
import com.entity.Order;

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
	
	@Test
	public void testMany2OneDelete(){
		//在不设定级联关系的情况下，且1这一端的对象有n的对象在引用，则不能直接删除1的这一端的对象
		Customer customer = (Customer) session.get(Customer.class, 1);
		session.delete(customer);
		
	}
	
	@Test
	public void testMany2OneUpdate(){
		Order order = (Order) session.get(Order.class, 1);
		order.getCustomer().setCustomerName("AAA");
	}
	
	@Test
	public void testMany2OneGet(){
		//1.若查询多的一端的一个对象，则默认情况下只查询了多的一端的对象，而没有查询关联的1的那一端的对象
		Order order = (Order) session.get(Order.class, 1);
		System.out.println(order.getOrderName());
		
		//2.在需要使用到关联的对象时，才发送对应的SQL语句
		Customer customer = order.getCustomer();
		System.out.println(customer.getCustomerName());
		
		//3.在查询Customer对象时，由多的一端导航到1的一端时，
		//若此时session已被关闭，则默认情况下会发生LazyInitializationException异常
	}
	
	@Test
	public void testMany2OneSave(){
		
		Customer customer = new Customer();
		customer.setCustomerName("AA");
		
		
		Order order1 = new Order();
		order1.setOrderName("ORDER-1");
		
		Order order2 = new Order();
		order2.setOrderName("ORDER-2");
		
		//设定关联关系
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		//执行save操作: 先插入Customer，再插入Order
		//先插入1的一端，再插入n的一端，只有INSERT语句
		session.save(customer);
		session.save(order1);
		session.save(order2);
	}
}
