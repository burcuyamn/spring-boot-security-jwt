package com.blog.my.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STORY")
@EntityListeners(AuditingEntityListener.class)
public class Story extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "USER_OID")
    private User user;

    @OneToOne
    @JoinColumn(name = "CATEGORY_OID")
    private Category category;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String body;

    @Column(name = "CREATED_DATE")
    private Date createdDate;


    public Story(){}

    public Story(User user, Category category, String title, String body, Date createdDate){
        this.user = user;
        this.category = category;
        this.title = title;
        this.body = body;
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
