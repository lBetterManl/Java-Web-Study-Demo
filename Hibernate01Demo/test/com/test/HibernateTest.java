package com.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.entity.News;

public class HibernateTest {
	
	/**
	 * 建好POJO object, XML Mapping File,配置文件(hibernate.cfg.xml).生成数据库表
	 */
	@Test
	public void Tool(){
		//读取配置文件 
        Configuration cfg = new Configuration().configure(); 
        //创建SchemaExport对象 
        SchemaExport export = new SchemaExport(cfg); 
        //创建数据库表 
        export.create(true,true); 
	}
	
	/**
	 * 保存数据
	 */
	@Test
	public void Test(){
		
		//1. 创建SessionFactory 对象
		SessionFactory sessionFactory = null;
		
		//1). 创建Configuration 对象：对应hibernate 的基本配置信息和对象关系映射信息
		Configuration configuration = new Configuration().configure();
		
		//4.0之前这样创建
		//SessionFactory = configuration.buildSessionFactory();
		
		//2). 创建一个ServiceRegistry 对象：hibernate 4.x 新添加的对象
		//hibernate 的任何配置和服务器都需要在该对象中注册后才能有效
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		//3).
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		//2. 创建一个Session 对象
		Session session = sessionFactory.openSession();
		
		//3. 开启事务
		Transaction transaction = session.beginTransaction();
		
		//4. 执行保存操作
//		News news = new News("java","ATGUIGU",new Date(new java.util.Date().getTime()));
//		session.save(news);
		
		//根据id 获取News
		News news2 = (News) session.get(News.class, 1);
		System.out.println(news2);
		
		//5. 提交事务
		transaction.commit();
		
		//6. 关闭Session
		session.close();
		
		//7. 关闭SessionFactory 对象
		sessionFactory.close();
	}

}
