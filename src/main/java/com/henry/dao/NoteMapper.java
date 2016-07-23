package com.henry.dao;

import com.henry.entity.Note;

public interface NoteMapper {
	
	Note selectById(Integer id);
	
	int updateStatusById(Integer id);
	
	int deleteById(Integer id);
	
	int updateByIdSelective(Note note);
}
