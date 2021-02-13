package com.cpe.sukuna.entity;

import com.google.api.client.util.DateTime;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@ToString
@Table(name = "event_datail")
@Data
public class Event {
    @GeneratedValue
    @Id
    @Column(name = "ev_id")
    private int ev_id;

    @Column(name = "eventroomid")
    private int eventroomid;

    @Column(name = "title")
    private String title;

    @Column(name = "start")
    private Timestamp start;

    @Column(name = "color")
    private String color;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "end")
    private Timestamp end;


}
