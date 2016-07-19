package com.henry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.henry.entity.Notebook;
import com.henry.service.NotebookService;

@Controller
@RequestMapping("/notebook")
public class NotebookController {
	
	@Autowired
	private NotebookService notebookService;
	
	@RequestMapping("/list/{id}")
	public ModelAndView list(ModelAndView mav, @PathVariable Integer id) {
		mav.setViewName("notebookList");
		List<Notebook> notebooks = notebookService.selectByUserId(id);
		mav.addObject("notebooks", notebooks);
		return mav;
	}
}
