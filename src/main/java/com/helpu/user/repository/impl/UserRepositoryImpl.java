package com.helpu.user.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.helpu.beans.User;
import com.helpu.generic.persistence.repository.BaseRepository;
import com.helpu.user.repository.UserRepository;

@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save() {
		
		String sql = "UPDATE zheng.USER SET SCORE = ? WHERE NAME = ?";
		jdbcTemplate.update(sql, 100,"zheng");
		
		String sql2 = "INSERT INTO zheng.USER(id,name,score) VALUES(?,?,?,)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{"a","zhao","98"});
		batchArgs.add(new Object[]{"b","qian","96"});
		jdbcTemplate.batchUpdate(sql2,batchArgs);
	}
	

	@Override
	public void update(Object targetObject) {
		
		
	}


	public void update() {
		// TODO Auto-generated method stub
		
	}

}
