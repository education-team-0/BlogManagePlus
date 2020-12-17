package com.whu.service;

import com.whu.entity.Comment;
import com.whu.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-11-23 15:26
 */
@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public String publicComment(Comment comment){
        commentMapper.publishComment(comment);
        return "评论成功!";
    }

    public String deleteComment(Integer commentId){
        commentMapper.deleteComment(commentId);
        return "评论已删除!";
    }

    public List<Comment> selectCommentsByBlog(Integer blogId){
        return commentMapper.selectCommentsByBlog(blogId);
    }


    public List<Comment> selectCommentsByUser(String username){
        return commentMapper.selectCommentsByUser(username);
    }


}
