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
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(generator = "USER_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_GEN", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
}
