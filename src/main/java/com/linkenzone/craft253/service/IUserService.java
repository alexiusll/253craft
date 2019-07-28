package com.linkenzone.craft253.service;

import com.linkenzone.craft253.entities.User;

public interface IUserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    //int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    //int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Boolean checkLogin(User user);

    User selectByAttribute(String name,Object value);
}
