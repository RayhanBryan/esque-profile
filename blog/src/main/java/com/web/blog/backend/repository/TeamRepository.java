package com.web.blog.backend.repository;

import com.web.blog.backend.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TeamRepository extends JpaRepository<Teams, Long> {
    List<Teams> findAllByOrderByTeamId();
}
