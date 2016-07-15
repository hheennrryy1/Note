package com.henry.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.entity.User;
import com.henry.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	@ResponseBody
	public String register(User user) throws UnsupportedEncodingException {
		User u = userService.selectByUsername(user.getUsername());
		if(u!=null) {
			return "fail";//用户名已存在
		}
		userService.insert(user);
		return "success";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(String username, String password, HttpSession session) throws UnsupportedEncodingException {
		int status = 0;//用户名或密码错误
		User user = userService.selectByUsername(username);
		if(user==null) {
			status = -1;//用户不存在
			return status;
		}
		password = userService.encode(password, user.getSalt()); //加盐 
		if(user.getPassword().equals(password)) {
			status = 1;//正确登录
			session.setAttribute("username", username);
		}
		return status;
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/password")
	public String password() {
		return "password";
	}
}
