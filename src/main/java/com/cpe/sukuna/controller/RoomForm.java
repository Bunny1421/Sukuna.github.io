package com.cpe.sukuna.controller;

import com.cpe.sukuna.entity.Event;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
public class RoomForm {

    private int rd_id;

    private String rd_name;

    private int rd_id_status;

    private String rd_floor;

    private String rd_building;

    private int rd_id_branch;

    private List<Event> eventList;
}
