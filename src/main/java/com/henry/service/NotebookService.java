package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henry.dao.NotebookMapper;
import com.henry.entity.Notebook;

@Service
public class NotebookService {
	
	@Autowired
	private NotebookMapper mapper;
	
	public List<Notebook> selectByUserId(Integer id) {
		return mapper.selectByUserId(id);
	}
	
}
