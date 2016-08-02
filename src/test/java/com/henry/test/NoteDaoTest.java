package com.henry.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henry.dao.NoteMapper;
import com.henry.entity.Note;
import com.henry.entity.User;

public class NoteDaoTest extends BasicTest {
	
	@Autowired
	NoteMapper mapper;
	
	@Test
	@Ignore
	public void select() {
		Note note = mapper.selectById(1);
		System.out.println(note.getTitle());
	}
	
	@Test
	public void selectByStatusAndUserId() {
		Note note = new Note();
		note.setStatus((byte)1);
		note.setUser(new User(1, null));
		
		//获取第1页，2条内容
		PageHelper.startPage(2, 2);
		List<Note> list = mapper.selectByStatusAndUserId(note);
		
		PageInfo<Note> page = new PageInfo<Note>(list);
		
		System.out.println(page.getPages());
	}
}
