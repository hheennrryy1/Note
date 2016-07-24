package com.henry.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.henry.entity.Notebook;
import com.henry.entity.User;
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
		int count = notebookService.countNotesById(id);
		mav.addObject("notebooks", notebooks);
		return mav;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Notebook notebook, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		Notebook nbk = notebookService.selectByname(notebook.getName());
		if(nbk!=null) {
			return "fail";
		}
		notebook.setCreatetime(new Date());
		notebook.setUser(user);
		notebookService.insert(notebook);
		return "success";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		notebookService.delete(id);
		return "redirect:/notebook/list/" + user.getId();
	}
	
	@RequestMapping("/noteList/{id}")
	public ModelAndView noteList(@PathVariable Integer id, ModelAndView mav) {
		mav.setViewName("noteList");
		Notebook notebook = notebookService.selectNotesById(id);
		mav.addObject("notebook", notebook);
		return mav;
	}
}
