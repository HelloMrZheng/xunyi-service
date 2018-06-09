package com.helpu.user;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.helpu.beans.User;

@Repository
public class DepartmentDao extends JdbcDaoSupport{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}

	public User get(Integer id){
		String sql = "SELECT id,name,score FROM zheng.USER WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
	
}
