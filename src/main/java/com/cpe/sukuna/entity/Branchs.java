package com.cpe.sukuna.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "branchs")
@Data
public class Branchs {
    @GeneratedValue
    @Id
    @Column(name = "b_id")
    private int b_id;

    @Column(name = "b_name")
    private String b_name;

    @Column(name = "b_nickname")
    private String b_nickname;

}
