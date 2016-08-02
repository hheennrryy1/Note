package com.henry.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.henry.entity.Note;
import com.henry.entity.Notebook;
import com.henry.entity.User;
import com.henry.service.NoteService;
import com.henry.service.NotebookService;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	Logger logger = Logger.getLogger(NoteController.class);
	
	@Autowired
	private NoteService noteService;
	@Autowired
	private NotebookService notebookService;
	
	private User user;
	
	@ModelAttribute
	public void getUser(HttpSession session) {
		logger.info("ModelAttr");
		user = (User) session.getAttribute("user");
	}
	
	/**
	 * 只更新状态，移到废纸篓，不是真正删除
	 * 
	 * @param id note的id
	 * @param nbid notebook的id 用于更新状态后的跳转,如果不为空,就跳转到笔记本的笔记列表，如果为空就跳转到所有笔记
	 * @return
	 */
	@RequestMapping("/updateStatus/{id}")
	public String updateStatus(HttpSession session, @PathVariable Integer id,
			@RequestParam(value = "nbid", required=false) Integer nbid,
			@RequestParam("status") Byte status) {
		User user = (User) session.getAttribute("user");
		
		Note note = new Note();
		note.setId(id);
		note.setStatus(status);
		
		noteService.updateByIdSelective(note);
		
		//转发到所有笔记
		if(nbid==null) {
			StringBuilder sb = new StringBuilder("redirect:/note/list/");
			sb.append(user.getId()).append("?status=")
				.append(status).append("&pageNum=1");
			return sb.toString();
		}
		
		//转发到该笔记的所有笔记
		return "redirect:/notebook/noteList/" + nbid;
	}
	
	/**
	 * 选择单个note 
	 * 转向到更新note的页面
	 */
	@RequestMapping("/select/{id}")
	public ModelAndView select(ModelAndView mav, @PathVariable Integer id) {
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
		Notebook notebook = new Notebook(notebookName, null, user);
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
	public ModelAndView list(ModelAndView mav, @PathVariable Integer userId, 
			@RequestParam() Byte status, @RequestParam int pageNum) {
		Note note = new Note(status, new User(userId, null));
		
		PageInfo<Note> page = noteService.selectByStatusAndUserId(note, pageNum);
		mav.addObject("page", page);
		
		if(status==1) {
			mav.setViewName("allNoteList");
		}
		
		else if(status==0) {
			mav.setViewName("trash");
		}
		
		return mav;
	}
	
	/**
	 * 转向到插入笔记的页面
	 */
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
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
	public ModelAndView insert(ModelAndView mav, Note note) {
		Notebook notebook = note.getNotebook();
		notebook.setUser(user);
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
	
	/**
	 * 从废纸篓彻底删除note 
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		noteService.deleteById(id);
		return "redirect:/note/list/" + user.getId() + "?status=0&pageNum=1";
	}
}
