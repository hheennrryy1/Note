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

import com.henry.entity.Note;
import com.henry.entity.Notebook;
import com.henry.entity.User;
import com.henry.service.NoteService;
import com.henry.service.NotebookService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	@Autowired
	private NotebookService notebookService;
	
	/**
	 * 只更新状态，移到废纸篓，不是真正删除
	 * 
	 * @param id note的id
	 * @param nbid notebook的id 用于更新状态后的跳转
	 * @return
	 */
	@RequestMapping("/updateStatus/{id}")
	public String updateStatus(@PathVariable Integer id, @RequestParam("nbid") Integer nbid) {
		noteService.updateStatusById(id);
		return "redirect:/notebook/noteList/" + nbid;
	}
	
	/**
	 * 选择单个note 
	 */
	@RequestMapping("/select/{id}")
	public ModelAndView select(ModelAndView mav, @PathVariable Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		mav.setViewName("note");
		Note note = noteService.selectById(id);
		mav.addObject("note", note);
		Notebook notebook = new Notebook();
		notebook.setUser(user);
		List<Notebook> notebooks = notebookService.selectiveSelect(notebook);
		mav.addObject("notebooks", notebooks);
		return mav;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Note note) {
		note.setUpdatetime(new Date());
		int flag = noteService.updateByIdSelective(note);
		if(flag>0) {
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping("/updateNotebookId")
	@ResponseBody
	public String updateNotebookId(String notebookName, String noteId) {
		Notebook notebook = new Notebook();
		notebook.setName(notebookName);
		
		//根据notebook名字找到id
		notebook = notebookService.selectiveSelect(notebook).get(0);
		Note note = new Note();
		note.setNotebook(notebook);
		
		//更新notebook的id
		int flag = noteService.updateByIdSelective(note);
		
		if(flag>0) {
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping("/list/{userId}")
	public ModelAndView list(ModelAndView mav, @PathVariable Integer userId, @RequestParam Byte status) {
		Note note = new Note(status, new User(userId, null));
		List<Note> notes = noteService.selectByStatusAndUserId(note);
		mav.addObject("notes", notes);
		mav.setViewName("allNoteList");
		return mav;
	}
}
