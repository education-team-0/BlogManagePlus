package com.whu.mapper;

import com.whu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-10-21 10:24
 */
@Repository
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Insert("insert into user(name,pwd) values(#{name},#{pwd})")
    void addUser(User user);

    @Select("select * from user where name=#{name}")
    User findByName(String name);


    @Select("select role from user2 where username={name}")
    String findRoleByName(String name);




}
