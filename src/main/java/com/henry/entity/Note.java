package com.henry.entity;

import java.util.Date;

public class Note {
    private Integer id;

    private String title;
    
    private Date createtime;
    
	private Date updatetime;

    private String content;
    
    private Byte status;

	private Notebook notebook;
	
	private User user;

	public Note(){}

    public Note(Byte status, User user) {
		super();
		this.status = status;
		this.user = user;
	}
    
	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", createtime=" + createtime + ", updatetime=" + updatetime
				+ ", content=" + content + ", status=" + status + ", notebook=" + notebook + ", user=" + user + "]";
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

    public Date getCreatetime() {
    	return createtime;
    }
    
    public void setCreatetime(Date createtime) {
    	this.createtime = createtime;
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
    
    public Byte getStatus() {
    	return status;
    }
    
    public void setStatus(Byte status) {
    	this.status = status;
    }
    
	public Notebook getNotebook() {
		return notebook;
	}

	public void setNotebook(Notebook notebook) {
		this.notebook = notebook;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}