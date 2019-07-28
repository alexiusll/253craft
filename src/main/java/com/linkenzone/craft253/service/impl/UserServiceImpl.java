package com.linkenzone.craft253.service.impl;

import com.linkenzone.craft253.entities.User;
import com.linkenzone.craft253.mapper.UserMapper;
import com.linkenzone.craft253.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public Boolean checkLogin(User user) {
        User user1 = userMapper.selectByAttribute("name", user.getName());
        if(user1 != null){
            if(user1.getName().equals(user.getName()) && user1.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User selectByAttribute(String name, Object value) {
        return userMapper.selectByAttribute(name,value);
    }
}
