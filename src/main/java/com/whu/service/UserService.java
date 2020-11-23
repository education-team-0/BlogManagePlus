package com.whu.service;

import com.whu.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.whu.mapper.UserMapper;
import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-10-21 10:37
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 查找全部User
     * @return
     */
    public List<User> findAll(){
        return userMapper.findAll();
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public User findById(int id){
        return userMapper.findById(id);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    public String addUser(User user){
        userMapper.addUser(user);
        return "Add success";
    }


    /**
     * 根据名字查找用户
     * @param name
     * @return
     */
    public User findByName(String name){
        return userMapper.findByName(name);
    }



}
