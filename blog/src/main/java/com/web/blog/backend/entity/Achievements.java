package com.web.blog.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Achievements {
    @Id
    @GeneratedValue(generator = "ACHIEVEMENT_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ACHIEVEMENT_GEN", sequenceName = "ACHIEVEMENT_SEQ", allocationSize = 1)
    @Column(name = "ACHIEVEMENT_ID")
    private Long achievementId;
    @Column(name = "URL")
    private String url;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TEXT_ACHIEVEMENT")
    private String textAchievement;
}
