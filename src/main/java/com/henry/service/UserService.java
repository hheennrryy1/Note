package com.henry.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.UserMapper;
import com.henry.entity.User;
import com.henry.utils.PasswordUtil;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public int insert(User user) throws UnsupportedEncodingException {
		String password = user.getPassword();
		String salt = PasswordUtil.generate();
		user.setSalt(salt);
		password = PasswordUtil.encode(password, salt);//加salt再sha512
		user.setPassword(password);
		return mapper.insert(user);
	}
	
	public User selectByUsername(String username) {
		return mapper.selectByUsername(username);
	}
	
	public int selectIdByUsername(String username) {
		return mapper.selectIdByUsername(username);
	}
	
	public int updatePasswordById(User user) {
		return mapper.updatePasswordById(user);
	}
	
	public String encode(String password, String salt) {
		return PasswordUtil.encode(password, salt);
	}
}
