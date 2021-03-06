package com.henry.dao;

import java.util.List;

import com.henry.entity.Notebook;

public interface NotebookMapper {
	
	List<Notebook> selectiveSelect(Notebook notebook);
	
	int countNotesById(Integer id);
	
	Notebook selectNotesById(Integer id);
	
	int insert(Notebook notebook);
	
	int deleteById(Integer id);
}
