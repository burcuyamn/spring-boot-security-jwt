package com.blog.my.model;

import com.blog.my.model.category.Category;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "STORY")
@EntityListeners(AuditingEntityListener.class)
public class Story extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "USER_OID")
    private User user;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String body;

    @OneToOne
    @JoinColumn(name = "CATEGORY_OID")
    private Category category;

    public Story(){}

    public Story(User user, String title, String body, Category category){
        this.user = user;
        this.title = title;
        this.body = body;
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
