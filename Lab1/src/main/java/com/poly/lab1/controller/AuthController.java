package com.poly.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    HttpServletRequest request;

    // Hiển thị form login
    @GetMapping("/login/form")
    public String form() {
        return "views/login";
    }

    // Xử lý đăng nhập
    @PostMapping("/login/check")
    public String login(Model model) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("poly".equals(user) && "123".equals(pass)) {
            model.addAttribute("message", " Đăng nhập thành công!");
        } else {
            model.addAttribute("message", " Sai tài khoản hoặc mật khẩu!");
        }
        return "views/login";
    }
}
