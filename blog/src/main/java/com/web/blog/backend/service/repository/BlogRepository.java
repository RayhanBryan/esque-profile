package com.web.blog.backend.service.repository;

import com.web.blog.backend.entity.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
