package com.blog.my.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "STORY")
@EntityListeners(AuditingEntityListener.class)
public class Story extends BaseEntity {

}
