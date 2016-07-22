package com.henry.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.henry.dao.NoteMapper;
import com.henry.entity.Note;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:Spring.xml", "classpath:Spring-Mybatis.xml"})
public class NoteDaoTest {
	
	@Autowired
	NoteMapper mapper;
	
	@Test
	public void select() {
		Note note = mapper.selectById(1);
		System.out.println(note.getTitle());
	}
}
