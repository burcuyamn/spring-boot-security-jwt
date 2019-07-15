package com.blog.my.repository;

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
    @Query("update Story set deleted = current_date where oid =:oid ")
    void deleteByOid(@Param("oid") String oid);
}
