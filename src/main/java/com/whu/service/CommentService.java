package com.whu.service;

import com.whu.mbgdao.CommentMapper;
import com.whu.mbgentity.Comment;
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
        int result=commentMapper.insert(comment);
        return result+"";
    }

    public String deleteComment(Integer commentId){
        int result=commentMapper.deleteByPrimaryKey(commentId);
        return result+"";
    }

    public List<Comment> selectCommentsByBlog(Integer blogId){
        return commentMapper.selectByBlog(blogId);
    }


    public List<Comment> selectCommentsByUser(String username){
        return commentMapper.selectByUser(username);
    }


}
