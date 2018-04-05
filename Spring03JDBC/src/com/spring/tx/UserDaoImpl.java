package com.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String findUserById(Integer id) {
		String sql = "SELECT address FROM users WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}

}
