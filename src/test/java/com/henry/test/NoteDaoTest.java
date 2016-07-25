package com.henry.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.henry.dao.NoteMapper;
import com.henry.entity.Note;
import com.henry.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:Spring.xml", "classpath:Spring-Mybatis.xml"})
public class NoteDaoTest {
	
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
		List<Note> list = mapper.selectByStatusAndUserId(note);
		System.out.println(list);
	}
}
