package com.blog.my.repository;

import com.blog.my.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, String> {
}
