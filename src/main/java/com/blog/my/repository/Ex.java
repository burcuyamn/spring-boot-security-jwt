package com.blog.my.repository;

import com.blog.my.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class Ex {

    @Autowired
    EntityManager entityManager;

    public List<User> findAllUser() {
        Session session = entityManager.unwrap(Session.class);
        SQLQuery s = session.createSQLQuery("Select * from Users u");
        return s.list();
    }
}
