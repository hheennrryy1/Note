package com.henry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.henry.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	/**
	 * 只更新状态，移到废纸篓，不是真正删除
	 * 
	 * @param id note的id
	 * @param nbid notebook的id 用于更新状态后的跳转
	 * @return
	 */
	@RequestMapping(value="/update/{id}")
	public String updateStatus(@PathVariable Integer id, @RequestParam("nbid") Integer nbid) {
		noteService.updateStatusById(id);
		return "redirect:/notebook/noteList/" + nbid;
	}
}
