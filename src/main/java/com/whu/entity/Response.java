package com.whu.entity;

/**
 * @author Hongchao Yang
 * @date 2020-10-21 11:11
 */
public class Response {
    private static final String OK="ok";
    private static final String ERROR="error";

    //元数据
    private Meta meta;
    //相应内容
    private Object data;

    public Response success(){
        this.meta=new Meta(true,OK);
        return this;
    }

    public Response success(Object data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return this;
    }

    public Response failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public Response failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }


}
