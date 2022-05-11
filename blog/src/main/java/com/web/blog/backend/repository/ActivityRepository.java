package com.web.blog.backend.repository;

import com.web.blog.backend.entity.Activity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByOrderByActivityIdDesc();
}
