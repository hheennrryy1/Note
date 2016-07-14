package com.henry.entity;

import java.util.Date;
import java.util.List;

public class Notebook {
    private Integer id;

    private String name;

    private Date createtime;
    
    private User user;
    
    private List<Note> notes;
    
    public Notebook(){};

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public List<Note> getNotes() {
		return notes;
	}


	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}