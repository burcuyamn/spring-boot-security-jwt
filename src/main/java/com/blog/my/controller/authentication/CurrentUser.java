package com.blog.my.controller.authentication;

import com.blog.my.model.User;

import java.util.Date;

public class CurrentUser {

    private String username;
    private String email;
    private Long loginTime;

    public CurrentUser(){}

    public CurrentUser(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.loginTime = new Date().getTime();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }
}
