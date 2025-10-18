package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    @RequestMapping("/ok")
    public String ok() {
        return "views/ok";
    }

    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("method", "m1()");
        return "views/ok";
    }

    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("method", "m2()");
        return "views/ok";
    }

    @RequestMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("method", "m3()");
        return "views/ok";
    }
}
