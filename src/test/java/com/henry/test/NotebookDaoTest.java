package com.henry.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henry.dao.NotebookMapper;
import com.henry.entity.Notebook;
import com.henry.entity.User;
import com.henry.service.NotebookService;

public class NotebookDaoTest extends BasicTest {
	
	@Autowired
	NotebookMapper mapper;
	
	@Autowired
	NotebookService service;
	
	@Test
	@Ignore
	public void selectNotesById() {
		mapper.selectNotesById(1);
	}
	
	@Test
	@Ignore
	public void count() {
		int i = mapper.countNotesById(8);
		System.out.println(i);
	}
	
	@Test
	@Ignore
	public void selective() {
		Notebook nb = new Notebook();
		nb.setId(6);
		List<Notebook> notebooks = mapper.selectiveSelect(nb);
		System.out.println(notebooks);
	}
	
	@Test
	public void selectNotes() {
		Notebook notebook = new Notebook();
		User user = new User();
		user.setId(2);
		notebook.setUser(user);
		
		PageInfo<Notebook> page = service.selectNotesByNtbkId(notebook, 1);
		System.out.println(page.getPages());
	}
}
