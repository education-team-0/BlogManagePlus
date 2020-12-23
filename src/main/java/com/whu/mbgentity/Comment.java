package com.whu.mbgentity;

import java.util.Date;

public class Comment {
    private Integer commentid;

    private Date time;

    private String username;

    private String content;

    private Integer blogid;

    public Comment(Integer commentid, Date time, String username, String content, Integer blogid) {
        this.commentid = commentid;
        this.time = time;
        this.username = username;
        this.content = content;
        this.blogid = blogid;
    }

    public Comment() {
        super();
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }
}