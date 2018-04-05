package com.yhc.jpa.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yhc.jpa.model.Customer;
import com.yhc.jpa.model.Order;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月7日 下午10:49:04
 */
public class JPA1Many2One {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("JPA01Demo");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
	}

	@After
	public void destory() {
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	//更新操作
	@Test
	public void testManyToOneUpdate(){
		Order order = entityManager.find(Order.class, 1);
		order.getCustomer().setLastName("FF");
	}
	
	//不能删除一的一端，因为有外键约束
	@Test
	public void testManyToOneRemove(){
		//多的一端能删
		Order order = entityManager.find(Order.class, 1);
		entityManager.remove(order);
		
		//一的一端不能删（因为有外键约束）
		Customer customer = entityManager.find(Customer.class, 1);
		entityManager.remove(customer);
	}
	
	//默认情况下，使用左外连接的方式来获取n的一端的对象和其关联的1的一端的对象
	//可以使用@ManyToOne 的fetch 来修改关联属性的加载策略
	@Test
	public void testManyToOneFind(){
		Order order = entityManager.find(Order.class, 1);
		System.out.println(order.getOrderName());
		
		System.out.println(order.getCustomer().getLastName());
	}
	
	/**
	 * 保存多对一时，建议先保存1的一端，后保存多的一端，这样不会多出额外的UPDATE语句
	 */
	@Test
	public void testManyToOne(){
		
		Customer customer = new Customer();
		customer.setAge(22);
		customer.setBirth(new Date());
		customer.setCreatedTime(new Date());
		customer.setEmail("123@qq.com");
		customer.setLastName("FF");
		
		Order order1 = new Order();
		order1.setOrderName("O-FF-1");
		
		Order order2 = new Order();
		order2.setOrderName("O-FF-2");
		
		//设置关联关系
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		//执行保存操作
		entityManager.persist(customer);
		entityManager.persist(order1);
		entityManager.persist(order2);
		
	}
	
	/**
	 * 同Hibernate 中Session 的refresh 方法
	 * 用数据库实体记录的值更新实体对象的状态，即更新实例的属性值
	 */
	@Test
	public void testRefresh(){
		Customer customer = entityManager.find(Customer.class, 3);
		customer = entityManager.find(Customer.class, 1);
		
		entityManager.refresh(customer);
	}
	
	/**
	 * 同Hibernate 中Session 的flush 方法
	 */
	@Test
	public void testFlush(){
		Customer customer = entityManager.find(Customer.class, 3);
		System.out.println(customer);
		
		//提交事务时自动更新
		customer.setLastName("CC");
		
		//不提交事务时手动更新
		//entityManager.flush();
	}

	// 若传入的是一个游离对象，即传入的对象有OID
	// 1.若在EntityManager 缓存有对应的对象
	// 2.JPA会把游离对象的属性复制到EntityManager 缓存的对象中
	// 3.对EntityManager 缓存的对象执行update操作
	@Test
	public void testMerge4() {
		Customer customer = new Customer();
		customer.setAge(20);
		customer.setBirth(new Date());
		customer.setCreatedTime(new Date());
		customer.setEmail("yhc8023tm@foxmail.com");
		customer.setLastName("DD");

		// 数据库中有id为4的记录
		customer.setId(4);
		
		Customer customer2 = entityManager.find(Customer.class, 4);
		entityManager.merge(customer);

		System.out.println(customer == customer2); // false
	}

	// 若传入的是一个游离对象，即传入的对象有OID
	// 1.若在EntityManager 缓存中没有该对象
	// 2.若在数据库中有对应的记录
	// 3.JPA会查询对应的记录，然后返回该记录对应的对象，在然后会把游离对象的属性复制到查询到的对象中
	// 4.对查询到的对象执行update操作
	@Test
	public void testMerge3() {
		Customer customer = new Customer();
		customer.setAge(20);
		customer.setBirth(new Date());
		customer.setCreatedTime(new Date());
		customer.setEmail("yhc8023tm@foxmail.com");
		customer.setLastName("DD");

		// 数据库中有id为4的记录
		customer.setId(4);

		Customer customer2 = entityManager.merge(customer);

		System.out.println(customer == customer2); // false
	}

	// 若传入的是一个游离对象，即传入的对象有OID
	// 1.若在EntityManager 缓存中没有该对象
	// 2.若在数据库中也没有对应的记录
	// 3.JPA会创建一个新的对象，然后把当前对象的属性复制到新创建的对象中
	// 4.对新创建的对象执行insert操作
	@Test
	public void testMerge2() {
		Customer customer = new Customer();
		customer.setAge(20);
		customer.setBirth(new Date());
		customer.setCreatedTime(new Date());
		customer.setEmail("yhc8023tm@foxmail.com");
		customer.setLastName("DD");

		// 数据库中没有id为100的记录
		customer.setId(100);

		Customer customer2 = entityManager.merge(customer);

		System.out.println("customer#id:" + customer.getId());
		System.out.println("customer2#id:" + customer2.getId());
	}

	/**
	 * 类似于Hibernate Session的saveOrUpdate
	 */
	// 1.若传入的是一个临时对象
	// 会创建一个新的对象，把临时对象的属性复制到新的对象中，然后对新的对象执行持久化操作，
	// 所以新的对象中有id，但以前的临时对象中没有id
	@Test
	public void testMerge1() {
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setBirth(new Date());
		customer.setCreatedTime(new Date());
		customer.setEmail("yhc8023tm@foxmail.com");
		customer.setLastName("CC");

		Customer customer2 = entityManager.merge(customer);

		System.out.println("customer#id:" + customer.getId());
		System.out.println("customer2#id:" + customer2.getId());
	}

	// 类似于Hibernate 的delete方法。把对象对应的记录从数据库中删除
	// 但注意：该方法只能移除持久化对象。而Hibernate 的delete 方法实际上还可以移除游离对象
	@Test
	public void testRemove() {
		// 移除不了
		// Customer customer = new Customer();
		// customer.setId(2);

		// 能移除
		Customer customer = entityManager.find(Customer.class, 2);

		entityManager.remove(customer);
	}

	// 类似于Hibernate 的save 方法.使对象由临时状态变为持久化状态
	// 和hibernate的save方法的不同之处：若对象有id，则不能进行insert操作，会抛出异常
	@Test
	public void testPersistence() {
		Customer customer = new Customer();
		customer.setAge(23);
		customer.setBirth(new Date());
		customer.setCreatedTime(new Date());
		customer.setEmail("yhc8023tm@foxmail.com");
		customer.setLastName("帅哥");

		entityManager.persist(customer);
		System.out.println(customer.getId());
	}

	// 类似于Hibernate 中Session 的load 方法(先打印--再打印sql语句，可能出现懒加载异常)
	@Test
	public void testGetReference() {
		Customer customer = entityManager.getReference(Customer.class, 1);
		System.out.println("---------------------------");
		System.out.println(customer);
	}

	// 类似于Hibernate 中 Session 的get 方法（先打印sql语句，在打印---）
	@Test
	public void testFind() {
		Customer customer = entityManager.find(Customer.class, 1);
		System.out.println("---------------------------1liIL0oO");
		System.out.println(customer);
	}

}
