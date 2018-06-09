package com.helpu.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.helpu.beans.User;

public class JdbcTest {

	private ApplicationContext ac = null;
	private JdbcTemplate jdbcTemplate;
	private DepartmentDao departmentDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	{
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
		departmentDao = ac.getBean(DepartmentDao.class);
		namedParameterJdbcTemplate = ac.getBean(NamedParameterJdbcTemplate.class);
	}
	
	@Test
	public void testNamedParameterJdbcTemplate2() {
		String sql = "INSERT INTO zheng.USER(ID,NAME) VALUES(:id,:name)";
		
		User user = new User();
		user.setId("7");
		user.setName("zhou");
		
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		
		namedParameterJdbcTemplate.update(sql, paramSource);

	}
	
	@Test
	public void testNamedParameterJdbcTemplate() {
		String sql = "INSERT INTO zheng.USER(ID,NAME,SCORE) VALUES(:id,:name,:sc)";
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", "namedJdbc");
		paramMap.put("name", "sun");
		paramMap.put("sc", 100);
		namedParameterJdbcTemplate.update(sql, paramMap);

	}
	
	@Test
	public void testDepartmentDao(){
		System.out.println(departmentDao.get(1));
	}
	
	@Test
	public void testUpdate() {
		String sql = "UPDATE zheng.USER SET SCORE = ? WHERE NAME = ?";
		jdbcTemplate.update(sql, 100,"zheng");
		String sql2 = "INSERT INTO zheng.USER(id,name,score) VALUES(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{"a","zhao","98"});
		batchArgs.add(new Object[]{"b","qian","96"});
		jdbcTemplate.batchUpdate(sql2,batchArgs);
	}
	
	@Test
	public void testDatasource() throws SQLException {
		DataSource dataSource = ac.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
}
