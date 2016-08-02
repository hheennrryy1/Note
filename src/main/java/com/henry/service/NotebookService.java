package com.henry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henry.dao.NotebookMapper;
import com.henry.entity.Notebook;

@Service
public class NotebookService {
	
	@Autowired
	private NotebookMapper mapper;
	
	public List<Notebook> selectiveSelect(Notebook notebook) {
		return mapper.selectiveSelect(notebook);
	}
	
	public PageInfo<Notebook> selectNotesByNtbkId(Notebook notebook, int pageNum) {
		//pageNum,pageSize 每页显示5条
		PageHelper.startPage(pageNum, 5);
		List<Notebook> notebooks =  mapper.selectiveSelect(notebook);
		PageInfo<Notebook> page = new PageInfo<Notebook>(notebooks);
		return page;
	}
	
	public int countNotesById(Integer id) {
		return mapper.countNotesById(id);
	}
	
	public Notebook selectNotesById(Integer id) {
		return mapper.selectNotesById(id);
	}
	
	public int insert(Notebook notebook) {
		return mapper.insert(notebook);
	}
	
	public int delete(Integer id) {
		return mapper.deleteById(id);
	}
}
