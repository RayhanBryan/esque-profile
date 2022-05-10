package com.web.blog.backend.service.repository;

import com.web.blog.backend.entity.Activity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
