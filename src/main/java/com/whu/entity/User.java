package com.whu.entity;

import lombok.*;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Hongchao Yang
 * @date 2020-10-21 10:23
 * 用户实体类
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Integer userId;
    private String pwd;
    private String name;
    private String introduction;
    private String email;
    private String avatar;

    public User(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class i=Class.forName("java.io.InputStream");
    }

}
