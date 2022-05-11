package com.web.blog.backend.repository;

import com.web.blog.backend.entity.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByBlogIdDesc();
}
