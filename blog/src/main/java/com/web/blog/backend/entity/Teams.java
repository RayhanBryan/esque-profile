package com.web.blog.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Teams {
    @Id
    @GeneratedValue(generator = "TEAM_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TEAM_GEN", sequenceName = "TEAM_SEQ", allocationSize = 1)
    @Column(name = "TEAM_ID")
    private Long teamId;
    @Column(name = "URL")
    private String url;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TEXT_ACHIEVEMENT")
    private String textTeam;
    @Column(name = "POSITIONS")
    private String position;
}
