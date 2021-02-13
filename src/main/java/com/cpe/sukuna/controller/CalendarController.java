package com.cpe.sukuna.controller;

import com.cpe.sukuna.entity.Branchs;
import com.cpe.sukuna.entity.RoomDetail;
import com.cpe.sukuna.service.CalenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
//
//@RestController
@Controller
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    public CalenService calenService;

    @GetMapping("")
    public String index(Model model) {
        List<CalenForm> branchDetail = calenService.getAllBranch();
        model.addAttribute("branchDetail", branchDetail);

        return "calendar/calen";
    }

//    @GetMapping("")
//    public List<CalenForm> index(Model model) {
//        List<CalenForm> branchDetail = calenService.getAllBranch();
//
//        return branchDetail;
//
//    }

    @PostMapping("/create-branch")
    public String createBranch(Branchs branchs){
        calenService.createBranchs(branchs);
        return "redirect:/calendar/createBranch";
    }

    @GetMapping("/create-branch")
    public String createBranch(Model model){
        return "calendar/createBranch";
    }



    @GetMapping("/create-room")
    public String createRoom(Model model){
        model.addAttribute("branchs",calenService.getBranch());
        return "calendar/createRoom";
    }

    @PostMapping("/create-room")
    public String createRoom(RoomDetail roomDetail){
        calenService.createRoom(roomDetail);
        return "redirect:/calendar/createRoom";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<CalenForm> branchDetail = calenService.getAllBranch();
        model.addAttribute("branchDetail", branchDetail);
        model.addAttribute("eventForm", new EventForm());
        return "calendar/createEvent";
    }

    @PostMapping("/create")
    public String create(EventForm eventForm,Model model) throws ParseException {
        System.out.println(eventForm);
         String s = calenService.save(eventForm);
         model.addAttribute("status",s);
        return "redirect:/calendar/";
    }

}
