package com.whu.controller;

import com.whu.entity.Comment;
import com.whu.entity.Response;
import com.whu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-11-23 15:26
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/publish")
    public Response publicComment(@RequestBody  Comment comment){
        String msg=commentService.publicComment(comment);
        return new Response().success(msg);
    }

    @RequestMapping("/delete")
    public Response deleteComment(Integer commentId){
        String msg=commentService.deleteComment(commentId);
        return new Response().success(msg);
    }

    @RequestMapping("/getbyblog")
    public Response selectCommentsByBlog(Integer blogId){
        List<Comment> commentList= commentService.selectCommentsByBlog(blogId);
        return new Response().success(commentList);
    }

    @RequestMapping("/getbyuser")
    public Response selectCommentsByUser(String username){
        List<Comment> commentList= commentService.selectCommentsByUser(username);
        return new Response().success(commentList);
    }




}
