package com.spring.tx.xml;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	//没有注解要添加这个
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public String findUserById(Integer id) {
		String sql = "SELECT address FROM users WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}

}
