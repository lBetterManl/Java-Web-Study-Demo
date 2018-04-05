package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.News;

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
	
	/**
	 * save() 方法插入
	 */
	@Test
	public void testInsert(){
		News news = new News("HHHH", "GG", new Date(new java.util.Date().getTime()));
		session.save(news);
	}
	
	/**
	 * 1.save() 方法
	 * 1).使一个临时对象变为持久化对象
	 * 2).为对象分配ID
	 * 3).在flush 缓存时会发送一条INSERT 语句
	 * 4).在save 方法之前的setID() 是无效的
	 * 5).持久化对象的ID是不能修改的
	 */
	@Test
	public void testSave(){
		News news = new News();
		news.setTitle("帅帅帅");
		news.setAuthor("hah");
		news.setDate(new Date());
		
		System.out.println(news);
		session.save(news);
	}
	
	
	/**
	 * persist() 也会执行INSERT 操作
	 * 
	 * 和save() 方法的区别：
	 * 在调persist 方法之前，若对象已经有id了，则不会执行INSERT ，会抛出异常
	 */
	@Test
	public void testPersist(){
		News news = new News();
		news.setTitle("DD");
		news.setAuthor("dd");
		news.setDate(new Date());
		
		session.persist(news);
	}
	
	
	/**
	 * get VS load:
	 * 
	 * 1.执行get 方法:会立即加载对象，
	 *   而执行load 方法，若不适用该对象，则不会立即执行查询操作，而返回一个代理对象
	 *   
	 *   get 是立即检索， load 是延迟检索
	 *   
	 * 2.若数据表中没有对应的记录，且Session 也没有关闭，同时需要使用对象时
	 *   get 返回null，  load 抛出异常
	 *   
	 * 3.load 方法可能会抛出LazyInitializationException 异常：在需要
	 *   初始化代理对象之前已经关闭了Session
	 */
	@Test
	public void testLoad(){
		News news = (News) session.load(News.class, 1);
		System.out.println(news.getClass().getName());
	}
	@Test
	public void testGet(){
		News news = (News) session.get(News.class, 1);
		System.out.println(news);
		
		//查询派生属性
		System.out.println(news.getDesc());
	}
	
	
	/**
	 * update
	 * 1.若更新一个持久化对象，不需要显示的调用update 方法，因为在调用Transaction的
	 *   commit() 方法时，会先执行session 的flush() 方法
	 *   
	 * 2.更新一个游离对象需要显示的调用session 的update 方法，可以把
	 *   一个游离对象变为持久化对象
	 *   
	 * 需要注意的点：
	 * 1.无论要更新的游离对象和数据表的记录是否一致，都会发送UPDATE 语句
	 *   如何能让update 方法不再盲目的发出update 语句呢？在.hbm.xml 文件的 class 节点设置
	 *   select-before-update=true (默认为false)，但通常不需要设置该属性 
	 * 2.若数据表中没有对应的记录，但还调用了update 方法，会抛出异常
	 * 3.当update() 方法关联一个游离对象时，如果在Session 的缓存中已经存在相同的OID 的持久化对象，会抛出异常
	 *   因为在Session缓存中不能有两个OID 相同的对象
	 */
	@Test
	public void testUpdate(){
		News news = (News) session.get(News.class, 1);
		
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		news.setAuthor("Oracle");
		
		session.update(news);
	}
	
	
	/**
	 * saveOrUpdate 方法，有则更新，无则插入
	 * 
	 * 注意：
	 * 1.若OID 不为null，但数据表中还没有和其对应的记录，会抛出异常
	 */
	@Test
	public void testSaveOrUpdate(){
		News news = new News("FF", "ff", new Date());
		news.setId(1);
		session.saveOrUpdate(news);
	}
	
	/**
	 * delete :执行删除操作。只要OID和数据表中的一条记录对应，就会准备执行
	 * 若OID 在数据表中没有对应的记录则抛出异常
	 * 
	 * 可以通过设置hibernate 配置文件  hibernate.use_identifier_rollback 为true
	 * 使删除对象后，把其OID 置为null （用的不多）
	 */
	@Test
	public void testDelete(){
		
		//游离对象
//		News news = new News();
//		news.setId(1);
		
		//持久化对象
		News news = (News) session.get(News.class, 1);
		
		session.delete(news);
	}
	
	
	/**
	 * evict :从session 从缓存中把指定的持久化对象移除
	 */
	@Test
	public void testEvict(){
		News news1 = (News) session.get(News.class, 1);
		News news2 = (News) session.get(News.class, 2);
		
		news1.setTitle("AA");
		news2.setTitle("BB");
		
		session.evict(news1);
	}
	
	
	/**
	 * 调用存储过程
	 */
	@Test
	public void testDoWork(){
		session.doWork(new Work(){

			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println(connection);
				
				//调用存储过程。
				
			}
		
		});
	}
	
	/**
	 * flush: 是数据库表中的记录和Session 缓存中的对象的状态保持一致，为了保持一致，则可能发送对应的SQL语句
	 * 1.在Transaction 的commit() 方法中：先调用session的flush 方法，再提交事务
	 * 2.flush() 方法可能会发送SQL 语句，但不会提交事务。
	 * 3.注意：在未提交事务或显示的调用session.flush() 方法之前，也有可能会进行flush 操作
	 * 1).执行HQL 或QBC 查询，会先进行flush() 操作以得到数据表中最新的记录
	 * 2).若记录的ID是由底层数据库使用自增方式生成的，则在调用save()方法后，就会立即发送INSERT 语句。
	 * 	因为sava 方法后，必须保证对象的ID 是存在的
	 */
	@Test
	public void test(){
		News news = (News) session.get(News.class, 1);
		news.setAuthor("帅哥");
		System.out.println(news); 
		System.out.println("test");
	}
	
	/**
	 * clear():清理缓存
	 */
	@Test
	public void testClear(){
		News news1 = (News) session.get(News.class, 1);
		System.out.println(news1);
		session.clear();
		News news2 = (News) session.get(News.class, 1);
		System.out.println(news2);
	}
	
	/**
	 * refresh() :会强制发送SELECT 语句，以使session中的状态与数据库一致
	 */
	@Test
	public void testRefresh(){
		News news = (News) session.get(News.class, 1);
		System.out.println(news);
		
		session.refresh(news);
		System.out.println(news);
	}
}
