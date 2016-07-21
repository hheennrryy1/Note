package com.henry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.henry.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping("/delete/{id}")
	public ModelAndView list(ModelAndView mav, @PathVariable Integer id) {
		noteService.deleteById(id);
		return mav;
	}
}
