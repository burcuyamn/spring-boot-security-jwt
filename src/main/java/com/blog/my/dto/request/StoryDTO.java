package com.blog.my.dto.request;

import com.blog.my.model.StoryBody;

import java.util.Date;
import java.util.List;

public class StoryDTO {
    private String oid;
    private String userOid;
    private String categoryOid;
    private String title;
    private List<StoryBody> body;
    private Date createdDate;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUserOid() {
        return userOid;
    }

    public void setUserOid(String userOid) {
        this.userOid = userOid;
    }

    public String getCategoryOid() {
        return categoryOid;
    }

    public void setCategoryOid(String categoryOid) {
        this.categoryOid = categoryOid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StoryBody> getBody() {
        return body;
    }

    public void setBody(List<StoryBody> body) {
        this.body = body;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
