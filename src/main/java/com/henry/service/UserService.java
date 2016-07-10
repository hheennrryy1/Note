package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.UserMapper;
import com.henry.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public int insert(User user) {
		return mapper.insert(user);
	}
}
