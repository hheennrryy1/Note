package com.henry.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.entity.User;
import com.henry.service.UserService;
import com.henry.utils.PasswordUtil;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/signin")
	@ResponseBody
	public String signin(User user) throws UnsupportedEncodingException {
		userService.insert(user);
		return "success";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(String username, String password) throws UnsupportedEncodingException {
		int status = 0;//用户名或密码错误
		User user = userService.selectByUsername(username);
		if(user==null) {
			status = -1;//用户不存在
			return status;
		}
		password = PasswordUtil.encode(password, user.getSalt());
		if(user.getPassword().equals(password)) {
			status = 1;//正确登录
		}
		return status;
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
