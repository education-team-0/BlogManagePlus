package com.whu.mapper;

import com.whu.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-11-23 15:29
 */
@Repository
public interface CommentMapper {

    /**
     * 发布评论
     * @param comment
     */
    @Insert("insert into comment(time,userName,content,blogId)" +
            "values(#{time},#{userName},#{content},#{blogId})")
    void publishComment(Comment comment);

    /**
     * 根据博客Id查找评论，即查找某一篇博客的评论
     * @param blogId
     * @return
     */
    @Select("select * from comment where blogId=#{blogId}")
    List<Comment> selectCommentsByBlog(Integer blogId);

    /**
     * 根据用户名查找评论，即查找某一用户的所有评论
     * @param userName
     * @return
     */
    @Select("select * from comment where userName = #{userName}")
    List<Comment> selectCommentsByUser(String userName);


    @Delete("delete from blog where commentId=#{commentId}")
    void deleteComment(Integer commentId);


}
