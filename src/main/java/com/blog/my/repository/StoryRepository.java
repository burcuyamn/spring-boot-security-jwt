package com.blog.my.repository;

import com.blog.my.model.Category;
import com.blog.my.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, String> {

    @Modifying
    @Query("select s from Story s where s.deleted is null")
    List<Story> findAll();

    @Modifying
    @Query("update Story set lastUpdated = current_timestamp, deleted = current_date, lastUpdated = current_date where oid =:oid ")
    void deleteByOid(@Param("oid") String oid);

    @Modifying
    @Query("update Story set lastUpdated = current_timestamp, category =:category, title =:title, body =:body  where oid =:oid ")
    void update(@Param("oid") String oid, @Param("category") Category category, @Param("title") String title, @Param("body") String body );
}
