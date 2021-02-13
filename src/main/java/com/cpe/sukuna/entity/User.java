package com.cpe.sukuna.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "user")
@Data
public class User {

    @GeneratedValue
    @Id
    @Column(name = "USER_ID")
    private int USER_ID;

    @Column(name = "USER_NAME")
    private String USER_NAME;

    @Column(name = "USER_EMAIL")
    private String USER_EMAIL;

    @Column(name = "USER_PASS")
    private String USER_PASS;






}
