package com.henry.dao;

import java.util.List;

import com.henry.entity.Note;

public interface NoteMapper {
	
	Note selectById(Integer id);
	
	List<Note> selectByStatusAndUserId(Note note);
	
	int updateStatusById(Integer id);
	
	int deleteById(Integer id);
	
	int updateByIdSelective(Note note);
	
	int insertSelective(Note note);
}
