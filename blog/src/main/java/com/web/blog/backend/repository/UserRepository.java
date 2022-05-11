package com.web.blog.backend.repository;

import java.util.List;

import com.web.blog.backend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserNameIgnoreCaseContaining(String userName);
}
