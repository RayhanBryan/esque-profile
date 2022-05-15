package com.web.blog.backend.repository;

import com.web.blog.backend.entity.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievements,Long> {
    List<Achievements> findAllByOrderByAchievementIdDesc();
}
