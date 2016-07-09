package com.henry.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/hello")
	public String hello(HttpSession session) {
		Map<String, Integer> map = new HashMap<>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
		session.setAttribute("name", "henry");
		session.setAttribute("map", map);
		session.setAttribute("list", places);
		return "hello";
	}
}
