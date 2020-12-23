package com.whu.mbgdao;

import com.whu.mbgentity.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {
    @Delete({
        "delete from blog",
        "where blogId = #{blogid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer blogid);

    @Insert({
        "insert into blog (blogId, title, ",
        "content, author, ",
        "publishTime, viewFrequency, ",
        "starNum, type, isPublished, ",
        "updateTime, desciption, ",
        "tags, commentNum, ",
        "collectNum)",
        "values (#{blogid,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{author,jdbcType=VARCHAR}, ",
        "#{publishtime,jdbcType=TIMESTAMP}, #{viewfrequency,jdbcType=VARCHAR}, ",
        "#{starnum,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, #{ispublished,jdbcType=INTEGER}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{desciption,jdbcType=VARCHAR}, ",
        "#{tags,jdbcType=VARCHAR}, #{commentnum,jdbcType=INTEGER}, ",
        "#{collectnum,jdbcType=INTEGER})"
    })
    int insert(Blog record);

    int insertSelective(Blog record);

    @Select({
        "select",
        "blogId, title, content, author, publishTime, viewFrequency, starNum, type, isPublished, ",
        "updateTime, desciption, tags, commentNum, collectNum",
        "from blog",
        "where blogId = #{blogid,jdbcType=INTEGER}"
    })

    Blog selectByPrimaryKey(Integer blogid);

    /**
     * 获取用户的所有博客和草稿
     * @return
     */
    @Select("select * from blog where author = #{userName}")
    //@ResultMap("com.whu.mbgdao.BlogMapper.BaseResultMap")
    List<Blog> selectByUser(String userName);

    /**
     * 获取用户的所有博客
     * @return
     */
    @Select("select * from blog where author = #{userName} and isPublished=true")
    //@ResultMap("com.whu.mbgdao.BlogMapper.BaseResultMap")
    List<Blog> getBlogList(String userName);


    /**
     * 查询用户的所有草稿
     * @param userName
     * @return
     */
    @Select("select * from blog where author = #{userName} and isPublished=false")
    //@ResultMap("com.whu.mbgdao.BlogMapper.BaseResultMap")
    List<Blog> getDraftBlogList(String userName);


    int updateByPrimaryKeySelective(Blog record);

    @Update({
        "update blog",
        "set title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "author = #{author,jdbcType=VARCHAR},",
          "publishTime = #{publishtime,jdbcType=TIMESTAMP},",
          "viewFrequency = #{viewfrequency,jdbcType=VARCHAR},",
          "starNum = #{starnum,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR},",
          "isPublished = #{ispublished,jdbcType=INTEGER},",
          "updateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "desciption = #{desciption,jdbcType=VARCHAR},",
          "tags = #{tags,jdbcType=VARCHAR},",
          "commentNum = #{commentnum,jdbcType=INTEGER},",
          "collectNum = #{collectnum,jdbcType=INTEGER}",
        "where blogId = #{blogid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Blog record);


    @Update({
            "update blog",
            "set viewFrequency = #{newFrequency,jdbcType=VARCHAR} ",
            "where blogId = #{blogid,jdbcType=INTEGER}"
    })
    int updateViewNum(int blogid,int newFrequency);

    @Update({
            "update blog",
            "set commentNum = #{newCommentNum,jdbcType=INTEGER} ",
            "where blogId = #{blogid,jdbcType=INTEGER}"
    })
    int updateCommentNum(int blogid,int newCommentNum);


    @Select({
            "select",
            "viewFrequency ",
            "from blog",
            "where blogId = #{blogid,jdbcType=INTEGER}"
    })
    int selectViewNum(int blogid);

    @Select({
            "select",
            "commentNum ",
            "from blog",
            "where blogId = #{blogid,jdbcType=INTEGER}"
    })
    int selectCommentNum(int blogid);


}