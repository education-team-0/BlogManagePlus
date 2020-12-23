package com.whu.mbgentity;

public class User {
    private Integer userid;

    private String name;

    private String pwd;

    private String introduction;

    private String email;

    private String avatar;

    public User(Integer userid, String name, String pwd, String introduction, String email, String avatar) {
        this.userid = userid;
        this.name = name;
        this.pwd = pwd;
        this.introduction = introduction;
        this.email = email;
        this.avatar = avatar;
    }
    public User(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }


    public User() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }
}