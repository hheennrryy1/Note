package com.henry.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.henry.dao.NotebookMapper;
import com.henry.entity.Notebook;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:Spring.xml", "classpath:Spring-Mybatis.xml"})
public class NotebookDaoTest {
	
	@Autowired
	NotebookMapper mapper;
	
	@Test
	public void select() {
		Notebook notebook = mapper.selectById(1);
		System.out.println(notebook.getUser().getUsername());
		
	}
	
}