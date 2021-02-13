package com.cpe.sukuna.service;

import com.cpe.sukuna.controller.CalenForm;
import com.cpe.sukuna.controller.EventForm;
import com.cpe.sukuna.controller.RoomForm;
import com.cpe.sukuna.entity.Branchs;
import com.cpe.sukuna.entity.Event;
import com.cpe.sukuna.entity.RoomDetail;
import com.cpe.sukuna.repository.BranchsRepository;
import com.cpe.sukuna.repository.EventRepository;
import com.cpe.sukuna.repository.RoomDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CalenService {
    public final BranchsRepository branchsRepository;
    @Autowired
    public final EventRepository eventRepository;

    final
    RoomDetailRepository roomDetailRepository;

    public CalenService(BranchsRepository branchsRepository, EventRepository eventRepository, RoomDetailRepository roomDetailRepository) {
        this.branchsRepository = branchsRepository;
        this.eventRepository = eventRepository;
        this.roomDetailRepository = roomDetailRepository;
    }

    public List<Branchs> getBranch(){
        return branchsRepository.findAll();
    }

    public  List<CalenForm> getAllBranch(){
        List<Branchs> branchsList = branchsRepository.findAll();
        CalenForm form ;
        List<CalenForm> list = new ArrayList<>();
        for (Branchs branch:branchsList){
            form = new CalenForm();
            form.setB_id(branch.getB_id());
            form.setB_name(branch.getB_name());
            form.setB_nickname(branch.getB_nickname());
            List<RoomDetail> roomDetail = roomDetailRepository.findAllByRd_id_branch(branch.getB_id());
            RoomForm room ;
            List<RoomForm> listRoom = new ArrayList<>();

            for (RoomDetail rooms : roomDetail){
                room = new RoomForm();
                room.setRd_id(rooms.getRd_id());
                room.setRd_building(rooms.getRd_building());
                room.setRd_floor(rooms.getRd_floor());
                room.setRd_id_status(rooms.getRd_id_status());
                room.setRd_id_branch(rooms.getRd_id_branch());
                room.setRd_name(rooms.getRd_name());
                List<Event> eventList = getEventById(rooms.getRd_id());
                room.setEventList(eventList);
                listRoom.add(room);
            }
            form.setRoomDetails(listRoom);
            list.add(form);
        }

        return list;
    }

    public List<Event> getEventById(int id){
        return eventRepository.findAllByEv_rd_id(id);

    }

    public String save(EventForm eventForm) throws ParseException {
        if(checkEvent(eventForm.getId(),eventForm.getStart(),eventForm.getStop()).isEmpty()){
            Event event = new Event();
            event.setEventroomid(eventForm.getId());
            event.setTitle(eventForm.getTitle());
            Date start=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(eventForm.getStart());
            Timestamp timestamp = new Timestamp(start.getTime());
            event.setStart(timestamp);
            event.setColor(eventForm.getColor());
            event.setDescription(eventForm.getDescription());
            event.setName(eventForm.getName());
            Date end=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(eventForm.getStop());
            Timestamp endd = new Timestamp(end.getTime());
            event.setEnd(endd);
            System.out.println(event);
            eventRepository.save(event);
            return "success";
        }else {
            return "cannot";
        }
    }

    public List<Event> checkEvent(int id, String start,String end){
        List<Event> events =eventRepository.findEvent(id,start,end);
        return events;
    }

    public void createBranchs(Branchs branchs){
        Branchs branchs1 = new Branchs();
        branchs1.setB_name(branchs.getB_name());
        branchs1.setB_nickname(branchs.getB_nickname());
        branchsRepository.save(branchs1);
    }

    public void createRoom(RoomDetail roomDetail){
        RoomDetail roomDetail1 = new RoomDetail();
        roomDetail1.setRd_name(roomDetail.getRd_name());
        roomDetail1.setRd_id_status(1);
        roomDetail1.setRd_floor(roomDetail.getRd_floor());
        roomDetail1.setRd_building(roomDetail.getRd_building());
        roomDetail1.setRd_id_branch(roomDetail.getRd_id_branch());
        System.out.println(roomDetail1);
        roomDetailRepository.save(roomDetail1);
    }

}
