package com.whu.service;



import com.whu.mbgdao.UserMapper;
import com.whu.mbgentity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return userMapper.selectAll();
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public User findById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    public String addUser(User user){
        int result=userMapper.insert(user);
        return result+"";
    }


    /**
     * 根据名字查找用户
     * @param name
     * @return
     */
    public User findByName(String name){
        return userMapper.selectByName(name);
    }



}
