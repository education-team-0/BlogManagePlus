package com.whu.entity;

/**
 * @author Hongchao Yang
 * @date 2020-10-21 11:13
 */
public class Meta {
    private boolean success;
    private String message;

    public Meta(boolean success) {
        this.success = success;
    }

    public Meta(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
