package com.henry.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.henry.dao.NotebookMapper;
import com.henry.entity.Notebook;
import com.henry.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:Spring.xml", "classpath:Spring-Mybatis.xml"})
public class NotebookDaoTest {
	
	@Autowired
	NotebookMapper mapper;
	
	@Test
	@Ignore
	public void select() {
		Notebook notebook = mapper.selectById(1);
		System.out.println(notebook.getUser().getUsername());
	}
	
	@Test
	@Ignore
	public void selectByUserId() {
		List<Notebook> notebooks = mapper.selectByUserId(2);
		for(Notebook nb : notebooks) {
			System.out.println(nb.getUser().getUsername());
		}
	}
	
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
	public void selective() {
		Notebook nb = new Notebook();
		User user = new User();
		user.setId(1);
		nb.setUser(user);
		//nb.setId(6);
		List<Notebook> notebooks = mapper.selectiveSelect(nb);
		System.out.println(notebooks);
	}
}
