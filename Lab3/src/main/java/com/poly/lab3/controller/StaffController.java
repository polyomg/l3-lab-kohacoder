package com.poly.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.entity.Staff;

import java.util.List;

@Controller
public class StaffController {
    Staff staff;
    List<Staff> list = List.of(
            Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
            Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
            Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
            Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
            Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
            Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build()
    );
    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn A")
                .level(2)
                .build();

        model.addAttribute("staff", staff);
        return "/views/staff-detail";
    }

    @RequestMapping("/staff/list")
    public String list(Model model) {

        model.addAttribute("list", list);
        return "/views/staff-list";
    }

    @RequestMapping("/staff/status")
    public String status(Model model) {
        model.addAttribute("list", list);
        return "/views/list-status";
    }

    @RequestMapping("/staff/controls")
    public String controls(Model model) {
        model.addAttribute("list", list);
        return "/views/list-controls";
    }}
