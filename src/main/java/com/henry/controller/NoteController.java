package com.henry.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 * 转向到更新note的页面
	 */
	@RequestMapping("/select/{id}")
	public ModelAndView select(ModelAndView mav, @PathVariable Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		mav.setViewName("note");
		Note note = noteService.selectById(id);
		//找到单个note
		mav.addObject("note", note);
		Notebook notebook = new Notebook(null, null, user);
		//找到该用户的所有笔记本
		List<Notebook> notebooks = notebookService.selectiveSelect(notebook);
		mav.addObject("notebooks", notebooks);
		return mav;
	}
	
	/**
	 * 更新note 
	 */
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
	
	/**
	 * 更新笔记所在的笔记本 
	 */
	@RequestMapping("/updateNotebookId")
	@ResponseBody
	public String updateNotebookId(String notebookName, Integer noteId) {
		Notebook notebook = new Notebook(notebookName, null, null);
		
		//根据notebook名字找到id
		notebook = notebookService.selectiveSelect(notebook).get(0);
		Note note = new Note();
		note.setNotebook(notebook);
		note.setId(noteId);
		//更新notebook的id
		int flag = noteService.updateByIdSelective(note);
		
		if(flag>0) {
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 转到笔记列表，显示该用户的所有笔记 
	 */
	@RequestMapping("/list/{userId}")
	public ModelAndView list(ModelAndView mav, @PathVariable Integer userId, @RequestParam Byte status) {
		Note note = new Note(status, new User(userId, null));
		List<Note> notes = noteService.selectByStatusAndUserId(note);
		mav.addObject("notes", notes);
		mav.setViewName("allNoteList");
		return mav;
	}
	
	/**
	 * 转向到插入笔记的页面
	 */
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		Notebook notebook = new Notebook(null, null, user);
		//找到用户的所有笔记本
		List<Notebook> notebooks = notebookService.selectiveSelect(notebook);
		mav.addObject("notebooks", notebooks);
		mav.setViewName("insertNote");
		return mav;
	}
	
	/**
	 * 插入笔记 
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ModelAndView insert(ModelAndView mav, HttpSession session, Note note) {
		User user = (User) session.getAttribute("user");
		
		Notebook notebook = note.getNotebook();
		//根据name找id
		notebook = notebookService.selectiveSelect(notebook).get(0);
		Date date = new Date();
		note.setCreatetime(date);
		note.setUpdatetime(date);
		note.setUser(user);
		note.setStatus((byte)1);
		note.setNotebook(notebook);
		noteService.insertSelective(note);
		mav.setViewName("redirect:/notebook/noteList/" + notebook.getId());
		return mav;
	}
}
