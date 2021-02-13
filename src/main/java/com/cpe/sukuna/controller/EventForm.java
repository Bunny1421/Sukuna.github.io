package com.cpe.sukuna.controller;

import com.google.api.client.util.DateTime;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class EventForm {

    private int ev_id;

    private int id;

    private String title;

    private String start;

    private String color;

    private String description;

    private String name;
    private String stop;
    private String tree;


    public EventForm(int ev_id, int id, String title, String start, String color, String description, String name, String stop) {
        this.ev_id = ev_id;
        this.id = id;
        this.title = title;
        this.start = start;
        this.color = color;
        this.description = description;
        this.name = name;
        this.stop = stop;
    }

    public EventForm() {
    }


}
