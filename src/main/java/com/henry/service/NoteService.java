package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henry.dao.NoteMapper;
import com.henry.entity.Note;

@Service
public class NoteService {
	
	@Autowired
	private NoteMapper mapper;
	
	public static final int PAGE_SIZE = 3;
	
	public Note selectById(Integer id) {
		return mapper.selectById(id);
	}
	
	public PageInfo<Note> selectByStatusAndUserId(Note note, int pageNum) {
		//pageNum 第几页,pageSize 每页显示多少条
		PageHelper.startPage(pageNum, PAGE_SIZE);
		List<Note> notes =  mapper.selectByStatusAndUserId(note);
		PageInfo<Note> page = new PageInfo<>(notes);
		return page;
	}
	
	public int deleteById(Integer id) {
		return mapper.deleteById(id);
	}
	
	public int updateByIdSelective(Note note) {
		return mapper.updateByIdSelective(note);
	}
	
	public int insertSelective(Note note) {
		return mapper.insertSelective(note);
	}
}
