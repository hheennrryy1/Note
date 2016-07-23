package com.henry.service;

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
	
	public int deleteById(Integer id) {
		return mapper.deleteById(id);
	}
	
	public int updateStatusById(Integer id) {
		return mapper.updateStatusById(id);
	}
	
	public int updateByIdSelective(Note note) {
		return mapper.updateByIdSelective(note);
	}
}
