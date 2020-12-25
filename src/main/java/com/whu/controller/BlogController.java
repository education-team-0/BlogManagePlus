package com.whu.controller;


import com.whu.entity.Response;
import com.whu.mbgentity.Blog;
import com.whu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-11-23 15:25
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/publish")
    public Response publicBlog(@RequestBody Blog blog){
        String msg;
        if(blog.getBlogid()==null){
            msg=blogService.publishBlog(blog);
        }
        else{
            msg=blogService.updateBlog(blog);
        }
        return new Response().success(msg);
    }

    @RequestMapping("/getall")
    public Response getAll(String username){
        List<Blog> blogList=blogService.getAll(username);
        return new Response().success(blogList);
    }

    @RequestMapping("/getblog")
    public Response getBlogList(String username){
        List<Blog> blogList=blogService.getBlogList(username);
        return new Response().success(blogList);
    }

    @RequestMapping("/getdraft")
    public Response getDraftBlogList(String username){
        List<Blog> blogList=blogService.getDraftBlogList(username);
        return new Response().success(blogList);
    }

    @RequestMapping("/update")
    public Response updateBlog(@RequestBody  Blog blog){
        String msg=blogService.updateBlog(blog);
        return new Response().success(msg);
    }

    @RequestMapping("/getBlogById")
    public Response getBlogList(int id){
        Blog blog=blogService.getBlogById(id);
        return new Response().success(blog);
    }

    @RequestMapping("/updateView")
    public Response updateViewNum(int blogid){
        int initView=blogService.selectViewNum(blogid);
        String msg=blogService.updateViewNum(blogid,initView+1);
        return new Response().success(msg);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Response delete(int blogid){
        String msg=blogService.deleteByPrimaryKey(blogid);
        return new Response().success(msg);
    }


}
