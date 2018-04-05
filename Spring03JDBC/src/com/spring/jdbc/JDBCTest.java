package com.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;

	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");	
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

	}

	
	
	/**
	 * 获取单个列的值，或做统计查询
	 */
	@Test
	public void testQueryForObject2(){
		String sql = "SELECT count(id) FROM users";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		
		System.out.println(count);
	}
	
	/**
	 * 查询实体类的集合
	 * 注意：调用的不是queryForList
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id, name, address FROM users WHERE id > ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		List<User> users = jdbcTemplate.query(sql, rowMapper,3);
		
		System.out.println(users);
	}
	
	
	/**
	 * 获取一个对象
	 * 注意： 需要调用queryForObject(String sql, RowMapper<> rowMapper, Object... args)
	 * 1.其中的 RowMapper 指定如何去映射结果集的行，常用的实现类为 BeanPropertyRowMapper
	 * 2.使用SQL 中列的别名完成列名和类的属性名的映射。例如last_name lastName
	 * 3.不支持级联属性。JdbcTemplate 到底是一个JDBC的小工具，而不是ORM 框架
	 */
	@Test
	public void testQueryForObject(){
		String sql = "SELECT id, name, address FROM users WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user= jdbcTemplate.queryForObject(sql, rowMapper, 2);
		
		System.out.println(user);
	}
	
	/**
	 * 批量更新 : 批量INSERT， UPDATE， DELETE
	 * 最后一个参数是 Object[] 的List 类型：因为修改一条记录需要一个 Object 的数组，那么多条就需要多个 Object 的数组
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO users(name, address) VALUES (?,?)";
		
		List<Object[]> batchArgs = new ArrayList<>();
		
		batchArgs.add(new Object[]{"AA","上海"});
		batchArgs.add(new Object[]{"BB","武汉"});
		batchArgs.add(new Object[]{"CC","广州"});
		batchArgs.add(new Object[]{"DD","香港"});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	/**
	 * 执行INSERT, UPDATE, DELETE
	 */
	@Test
	public void testUpdate(){
		String sql = "UPDATE users SET name = ? WHERE id = ?";
		jdbcTemplate.update(sql, "帅哥", 1);
	}
	
	@Test
	public void testDataSource() throws SQLException{
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
}
