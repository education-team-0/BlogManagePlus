package com.whu.service;

import com.whu.mbgdao.BlogMapper;
import com.whu.mbgentity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-11-23 15:25
 */
@Service
public class BlogService {

    @Autowired
    BlogMapper blogMapper;

    public String publishBlog(Blog blog){
        int result=blogMapper.insert(blog);
        return result+"";
    }


    public List<Blog> getAll(String username){
        return blogMapper.selectByUser(username);
    }

    public List<Blog> getBlogList(String username){
        return blogMapper.getBlogList(username);
    }

    public List<Blog> getDraftBlogList(String username){
        return blogMapper.getDraftBlogList(username);
    }

    public String updateBlog(Blog blog){
        int result=blogMapper.updateByPrimaryKey(blog);
        return result+"";
    }

    public Blog getBlogById(int id){
        return blogMapper.selectByPrimaryKey(id);
    }

    public String updateCommentNum(int blogid,int commentNum){
        int result=blogMapper.updateCommentNum(blogid,commentNum);
        return result+"";
    }

    public String updateViewNum(int blogid,int viewNum){
        int result=blogMapper.updateViewNum(blogid,viewNum);
        return result+"";
    }

    public int selectViewNum(int blogid){
        return blogMapper.selectViewNum(blogid);
    }

    public int selectCommentNum(int blogid){
        return blogMapper.selectCommentNum(blogid);
    }


//    @Autowired
//    BlogMapper blogMapper;
//
//    public String publishBlog(Blog blog){
//        blogMapper.publishBlog(blog);
//        return "博客发布成功!";
//    }
//
//
//    public List<Blog> getAll(String username){
//        return blogMapper.getAll(username);
//    }
//
//    public List<Blog> getBlogList(String username){
//        return blogMapper.getBlogList(username);
//    }
//
//    public List<Blog> getDraftBlogList(String username){
//        return blogMapper.getDraftBlogList(username);
//    }
//
//    public String updateBlog(Blog blog){
//        blogMapper.updateBlog(blog);
//        return "博客更新完成!";
//    }
//
//    public Blog getBlogById(int id){
//        return blogMapper.getBlogById(id);
//    }

}
