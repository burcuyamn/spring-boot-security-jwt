package com.blog.my.dto.request;

public class UserDTO {
    private String oid;
    private String username;
    private String password;
    private String email;

    public UserDTO(){}

    public UserDTO(String oid, String username, String email){
        this.oid = oid;
        this.username = username;
        this.email = email;
    }

    public UserDTO(String oid, String username, String password, String email){
        this.oid = oid;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
