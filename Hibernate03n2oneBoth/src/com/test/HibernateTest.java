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
	public void testDelete(){
		//在不设定级联关系的情况下，且1这一端的对象有n的对象在引用，则不能直接删除1的这一端的对象
		Customer customer = (Customer) session.get(Customer.class, 1);
		session.delete(customer);
	}
	
	@Test
	public void TestUpdate(){
		Customer customer = (Customer) session.get(Customer.class, 1);
		customer.getOrders().iterator().next().setOrderName("GGG");
	}
	
	@Test
	public void testOne2ManyGet(){
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer.getOrders().size());
	}
	
	@Test
	public void testOne2ManySave(){
		
		Customer customer = new Customer();
		customer.setCustomerName("AA");
		
		Order order1 = new Order();
		order1.setOrderName("ORDER-1");
		
		Order order2 = new Order();
		order2.setOrderName("ORDER-2");
		
		//设定关联关系
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		customer.getOrders().add(order1);
		customer.getOrders().add(order2);
		
		//执行save操作，可以在1的一端的set节点指定inverse=true来使1的一端放弃维护关联关系
		//建议设定set的inverse=true,且先插入1的这一端再插入多的这一端
		session.save(customer);
		
		session.save(order1);
		session.save(order2);
	}
}
