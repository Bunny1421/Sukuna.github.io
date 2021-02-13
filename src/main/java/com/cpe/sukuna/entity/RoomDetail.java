package com.cpe.sukuna.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "room_details")
@Data
public class RoomDetail {

    @GeneratedValue
    @Id
    @Column(name = "rd_id")
    private int rd_id;

    @Column(name = "rd_name")
    private String rd_name;

    @Column(name = "rd_id_status")
    private int rd_id_status;

    @Column(name = "rd_floor")
    private String rd_floor;

    @Column(name = "rd_building")
    private String rd_building;

    @Column(name = "rd_id_branch")
    private int rd_id_branch;

}
