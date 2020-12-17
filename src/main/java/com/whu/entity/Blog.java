package com.whu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.sql.DataSource;
import java.util.Date;

/**
 * @author Hongchao Yang
 * @date 2020-11-23 15:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    private Integer blogId;
    private String title;
    private String content;
    private String author;
    private Date publishTime;
    private Integer viewFrequency;
    private Integer star;
    private int isPublished;

    public Blog(String title, String content, String author, Date publishTime, Integer viewFrequency, Integer star, int isPublished) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishTime = publishTime;
        this.viewFrequency = viewFrequency;
        this.star = star;
        this.isPublished = isPublished;
    }
}
