package com.whu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hongchao Yang
 * @date 2020-11-23 15:11
 * 评论实体类
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Integer commentId;
    private Date time;
    private String content;
    private Integer blogId;
    private String userName;

    public Comment(Date time, String content, Integer blogId, String userName) {
        this.time = time;
        this.content = content;
        this.blogId = blogId;
        this.userName = userName;
    }
}
