package com.whu.mbgdao;

import com.whu.mbgentity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    @Delete({
        "delete from comment",
        "where commentId = #{commentid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer commentid);

    @Insert({
        "insert into comment (commentId, time, ",
        "userName, content, ",
        "blogId)",
        "values (#{commentid,jdbcType=INTEGER}, #{time,jdbcType=TIMESTAMP}, ",
        "#{username,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{blogid,jdbcType=INTEGER})"
    })
    int insert(Comment record);

    int insertSelective(Comment record);

    @Select({
        "select",
        "commentId, time, userName, content, blogId",
        "from comment",
        "where commentId = #{commentid,jdbcType=INTEGER}"
    })
    //@ResultMap("com.whu.mbgdao.CommentMapper.BaseResultMap")
    Comment selectByPrimaryKey(Integer commentid);

    /**
     * 根据博客Id查找评论，即查找某一篇博客的评论
     * @param blogId
     * @return
     */
    @Select("select * from comment where blogId=#{blogId}")
    //@ResultMap("com.whu.mbgdao.CommentMapper.BaseResultMap")
    List<Comment> selectByBlog(Integer blogId);

    /**
     * 根据用户名查找评论，即查找某一用户的所有评论
     * @param userName
     * @return
     */
    @Select("select * from comment where userName = #{userName}")
    List<Comment> selectByUser(String userName);



    int updateByPrimaryKeySelective(Comment record);

    @Update({
        "update comment",
        "set time = #{time,jdbcType=TIMESTAMP},",
          "userName = #{username,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "blogId = #{blogid,jdbcType=INTEGER}",
        "where commentId = #{commentid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comment record);
}