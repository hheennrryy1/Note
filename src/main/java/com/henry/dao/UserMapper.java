package com.henry.dao;

import com.henry.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
}