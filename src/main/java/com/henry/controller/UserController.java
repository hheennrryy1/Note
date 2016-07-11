package com.henry.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.entity.User;
import com.henry.service.UserService;

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
	public String login(User user) throws UnsupportedEncodingException {
		
		return "success";
	}
}
