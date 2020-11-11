package com.whu.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Hongchao Yang
 * @date 2020-10-21 10:23
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    private String pwd;
    private String name;

    public User(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }

}
