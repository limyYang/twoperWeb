package com.tpsoft.project.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class ServiceTest {
	@Autowired
	private JdbcTemplate jdbct;
	public Integer addUser(User user) {
		return jdbct.update("insert into user(id,name) value (?,?)",user.getId(),user.getName());
		
	}
	
	public List<User> getUserList(){
		return jdbct.query("select * from user", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return null;
			}
			
		});
	}
	public List<User> getUsers(){
		//前提为类和数据库中字段一一对应
		return jdbct.query("select * from user", new BeanPropertyRowMapper<>(User.class));
	}
}
