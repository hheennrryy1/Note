package com.henry.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.henry.dao.UserMapper;
import com.henry.entity.User;
import com.henry.service.UserService;

public class UserDaoTest extends BasicTest {
	
	@Autowired
	UserMapper mapper;
	
	@Autowired
	UserService userService;
	
	@Test
	@Ignore
	public void insert1() {
		User user = new User();
		user.setUsername("henry");
		user.setPassword("sdfssdfsdfd");
		//userService.insert(user);
	}
	
	@Test
	@Ignore
	public void delete() {
		mapper.deleteById(1);
	}
}
