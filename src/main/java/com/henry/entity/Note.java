package com.henry.entity;

import java.util.Date;

public class Note {
    private Integer id;

    private String title;
    
    private Date updatetime;

    private String content;
    
    private byte status;

	private Notebook notebook;
    
    public Note(){}

    @Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", updatetime=" + updatetime + ", content=" + content
				+ ", status=" + status + ", notebook=" + notebook + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    public byte getStatus() {
    	return status;
    }
    
    public void setStatus(byte status) {
    	this.status = status;
    }

	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}
}