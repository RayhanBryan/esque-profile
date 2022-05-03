package com.web.blog.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BLOGS")
public class Blog {
    @Id
    @GeneratedValue(generator = "BLOG_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "BLOG_GEN", sequenceName = "BLOG_SEQ", allocationSize = 1)
    @Column(name = "BLOG_ID")
    private Long blogId;
    @Column(name = "URL")
    private String url;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TEXT_BLOG")
    private String textBlog;
}
