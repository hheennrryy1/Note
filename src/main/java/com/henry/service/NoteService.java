package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.NoteMapper;
import com.henry.entity.Note;

@Service
public class NoteService {
	
	@Autowired
	private NoteMapper mapper;
	
	public Note selectById(Integer id) {
		return mapper.selectById(id);
	}
	
	public List<Note> selectByStatusAndUserId(Note note) {
		return mapper.selectByStatusAndUserId(note);
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
