package com.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User get(Integer id){
		String sql = "SELECT id, name, address FROM users WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user= jdbcTemplate.queryForObject(sql, rowMapper, id);
		
		return user;
		
	}
}
