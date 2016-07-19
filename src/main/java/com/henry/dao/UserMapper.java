package com.henry.dao;

import com.henry.entity.User;

public interface UserMapper {
    int deleteById(Integer uid);

    int insert(User user);

    int insertSelective(User user);

    User selectById(Integer uid);
    
    User selectByUsername(String username);
    
    int updatePasswordById(User user);
}