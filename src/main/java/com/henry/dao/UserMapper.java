package com.henry.dao;

import java.util.List;

import com.henry.entity.User;

public interface UserMapper {
    int deleteById(Integer uid);

    int insert(User user);

    int insertSelective(User user);
    
    List<User> selectiveSelect(User user);
    
    int selectIdByUsername(String username);
    
    int updatePasswordById(User user);
}