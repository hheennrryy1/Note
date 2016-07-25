package com.henry.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henry.entity.Notebook;
import com.henry.entity.User;
import com.henry.service.NotebookService;
import com.henry.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private NotebookService notebookService;
	
	/**
	 * 注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(User user) throws UnsupportedEncodingException {
		List<User> list = userService.selectiveSelect(user);
		if(!list.isEmpty()) {
			return "fail";//用户名已存在
		}
		userService.insert(user);
		//注册成功创建一个默认的笔记本
		int id = userService.selectIdByUsername(user.getUsername());
		user.setId(id);
		notebookService.insert(new Notebook(user.getUsername() + "的笔记本", new Date(), user));
		return "success";
	}
	
	/**
	 * 登录
	 */
	@RequestMapping("/login")
	@ResponseBody
	public int login(String username, String password, HttpSession session) throws UnsupportedEncodingException {
		int status = 0;//用户名或密码错误
		List<User> list = userService.selectiveSelect(new User(null, username));
		
		if(list.isEmpty()) {
			status = -1;//用户不存在
			return status;
		}
		
		User user = list.get(0);
		password = userService.encode(password, user.getSalt()); //加盐 
		if(user.getPassword().equals(password)) {
			status = 1;//正确登录
			session.setMaxInactiveInterval(60*30);//30分钟
			session.setAttribute("user", user);
		}
		return status;
	}
	
	/**
	 * 登出
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/Login.html";
	}
	
	/**
	 * 转向到首页
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	/**
	 * 转向到修改密码的页面
	 */
	@RequestMapping("/password")
	public String password() {
		return "password";
	}
	
	@RequestMapping("/updatePassword")
	@ResponseBody
	public String updatePassword(String oldPassword, String newPassword, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		oldPassword = userService.encode(oldPassword, user.getSalt());
		//判断旧密码是否正确
		if(oldPassword.equals(user.getPassword())) {
			newPassword = userService.encode(newPassword, user.getSalt());//加盐
			user.setPassword(newPassword);
			userService.updatePasswordById(user);
			return "success";
		}
		return "fail";
	}
}
