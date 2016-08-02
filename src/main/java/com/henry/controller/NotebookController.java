package com.henry.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.henry.entity.Notebook;
import com.henry.entity.User;
import com.henry.service.NotebookService;

@Controller
@RequestMapping("/notebook")
public class NotebookController {
	
	@Autowired
	private NotebookService notebookService;
	
	/**
	 * 根据用户id找到用户的所有笔记本
	 */
	@RequestMapping("/list/{userId}")
	public ModelAndView list(ModelAndView mav, @PathVariable Integer userId, @RequestParam Integer pageNum) {
		mav.setViewName("notebookList");
		//根据用户的id查出全部笔记本
		Notebook notebook = new Notebook(null, null, new User(userId, null));
		PageInfo<Notebook> page = notebookService.selectNotesByNtbkId(notebook, pageNum);
		mav.addObject("page", page);
		return mav;
	}
	
	/**
	 * 返回的是笔记本下的笔记数 
	 */
	@RequestMapping("/count")
	@ResponseBody
	public Integer count(ModelAndView mav, Integer id) {
		return notebookService.countNotesById(id);
	}
	
	/**
	 * 插入笔记本前先检测是否笔记本名字是否重复 
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Notebook notebook, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		notebook.setUser(user);
		//根据名字查笔记，以防名字重复
		List<Notebook> notebooks = notebookService.selectiveSelect(notebook);
		if(!notebooks.isEmpty()) {
			return "fail";
		}
		notebook.setCreatetime(new Date());
		notebook.setUser(user);
		notebookService.insert(notebook);
		return "success";
	}
	
	/**
	 * 根据id删除笔记本 
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		notebookService.delete(id);
		return "redirect:/notebook/list/" + user.getId() + "?pageNum=1";
	}
	
	/*
	 * 根据notebook的id找到笔记本下的全部笔记
	 */
	@RequestMapping("/noteList/{id}")
	public ModelAndView noteList(@PathVariable Integer id, ModelAndView mav) {
		mav.setViewName("noteList");
		Notebook notebook = notebookService.selectNotesById(id);
		mav.addObject("notebook", notebook);
		return mav;
	}
}
