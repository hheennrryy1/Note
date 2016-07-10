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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:Spring.xml", "classpath:Spring-Mybatis.xml"})
public class UserDaoTest {
	
	@Autowired
	UserMapper mapper;
	
	@Autowired
	UserService userService;
	
	@Test
	@Ignore
	public void insert() {
		/*
		User user = new User();
		user.setUsername("henry");
		user.setPassword("sdfsd");
		mapper.insert(user);
		*/
	}
	
	@Test
	public void insert1() {
		User user = new User();
		user.setUsername("henry");
		user.setPassword("sdfssdfsdfd");
		userService.insert(user);
	}
}
