package com.whu.mbgentity;

import java.util.Date;

public class Blog {
    private Integer blogid;

    private String title;

    private String content;

    private String author;

    private Date publishtime;

    private String viewfrequency;

    private Integer starnum;

    private String type;

    private Integer ispublished;

    private Date updatetime;

    private String desciption;

    private String tags;

    private Integer commentnum;

    private Integer collectnum;

    public Blog(Integer blogid, String title, String content, String author, Date publishtime, String viewfrequency, Integer starnum, String type, Integer ispublished, Date updatetime, String desciption, String tags, Integer commentnum, Integer collectnum) {
        this.blogid = blogid;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishtime = publishtime;
        this.viewfrequency = viewfrequency;
        this.starnum = starnum;
        this.type = type;
        this.ispublished = ispublished;
        this.updatetime = updatetime;
        this.desciption = desciption;
        this.tags = tags;
        this.commentnum = commentnum;
        this.collectnum = collectnum;
    }

    public Blog() {
        super();
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getViewfrequency() {
        return viewfrequency;
    }

    public void setViewfrequency(String viewfrequency) {
        this.viewfrequency = viewfrequency == null ? null : viewfrequency.trim();
    }

    public Integer getStarnum() {
        return starnum;
    }

    public void setStarnum(Integer starnum) {
        this.starnum = starnum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getIspublished() {
        return ispublished;
    }

    public void setIspublished(Integer ispublished) {
        this.ispublished = ispublished;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption == null ? null : desciption.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public Integer getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(Integer collectnum) {
        this.collectnum = collectnum;
    }
}