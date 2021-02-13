package com.cpe.sukuna.controller;

import com.cpe.sukuna.entity.RoomDetail;
import lombok.Data;
import java.util.List;

@Data
public class CalenForm {

    private int b_id;

    private String b_name;

    private String b_nickname;

    private List<RoomForm> roomDetails;

    public CalenForm() {
    }


}
