package com.web.blog.backend.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "ACTIVITYS")
public class Activity {
    @Id
    @GeneratedValue(generator = "ACTIVITY_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ACTIVITY_GEN", sequenceName = "ACTIVITY_SEQ", allocationSize = 1)
    @Column(name = "ACTIVITY_ID")
    private Long activityId;
    @Column(name = "URL")
    private String url;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TEXT_ACTIVITY")
    private String textActivity;
}
