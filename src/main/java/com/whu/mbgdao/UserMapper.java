package com.whu.mbgdao;

import com.whu.mbgentity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Delete({
        "delete from bloguser",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userid);

    @Insert({
        "insert into bloguser (userId, name, ",
        "pwd, introduction, ",
        "email, avatar)",
        "values (#{userid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{pwd,jdbcType=VARCHAR}, #{introduction,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{avatar,jdbcType=VARCHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "userId, name, pwd, introduction, email, avatar",
        "from bloguser",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    //@ResultMap("com.whu.mbgdao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer userid);

    @Select("select * from user")
    //@ResultMap("com.whu.mbgdao.UserMapper.BaseResultMap")
    List<User> selectAll();


    @Select({
            "select",
            "userId, name, pwd, introduction, email, avatar",
            "from bloguser",
            "where name = #{name}"
    })
    //@ResultMap("com.whu.mbgdao.UserMapper.BaseResultMap")
    User selectByName(String name);


    int updateByPrimaryKeySelective(User record);

    @Update({
        "update bloguser",
        "set name = #{name,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "introduction = #{introduction,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR}",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}