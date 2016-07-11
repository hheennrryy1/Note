package com.henry.entity;

public class User {
    private Integer uid;

    private String username;

    private String password;
    
    private String salt;
    
    public User() {}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt + "]";
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    public String getSalt() {
    	return salt;
    }
    
    public void setSalt(String salt) {
    	this.salt = salt;
    }
}