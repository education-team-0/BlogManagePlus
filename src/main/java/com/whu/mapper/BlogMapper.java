package com.whu.mapper;

import com.whu.entity.Blog;
import jnr.ffi.annotations.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hongchao Yang
 * @date 2020-11-23 15:29
 */
@Repository
public interface BlogMapper {

    /**
     * 获取用户的所有博客和草稿
     * @return
     */
    @Select("select * from blog where author = #{userName}")
    List<Blog> getAll(String userName);

    /**
     * 获取用户的所有博客
     * @return
     */
    @Select("select * from blog where author = #{userName} and isPublished=true")
    List<Blog> getBlogList(String userName);

    /**
     * 根据id获取博客
     * @param id
     * @return
     */
    @Select("select * from blog where blogId = #{id}")
    Blog getBlogById(int id);


    /**
     * 查询用户的所有草稿
     * @param userName
     * @return
     */
    @Select("select * from blog where author = #{userName} and isPublished=false")
    List<Blog> getDraftBlogList(String userName);


    /**
     * 发布博客/草稿
     * @param blog
     */
    @Insert("insert into blog(title,content,author,publishTime,isPublished) " +
            "values(#{title},#{content},#{author},#{publishTime},#{isPublished})")
    void publishBlog(Blog blog);

    /**
     * 更新博客内容
     * @param blog
     */
    @Update("update blog set title=#{title},content=#{content},publishTime=#{publishTime} where blogId=#{blogId}")
    void updateBlog(Blog blog);


//    /**
//     * 发布草稿
//     * @param blog
//     */
//    @Insert("insert into blog(title,content,author,publishTime,isPublished) " +
//            "values(#{title},#{content},#{author},#{publishTime},#{isPublished})")
//    void publicDraftBlog(Blog blog);



}
