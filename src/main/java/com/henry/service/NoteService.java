package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.NoteMapper;

@Service
public class NoteService {
	
	@Autowired
	private NoteMapper mapper;
	
	public int deleteById(Integer id) {
		return mapper.deleteById(id);
	}
}
