package com.poly.controller;

import com.poly.service.CookieService;
import com.poly.service.ParamService;
import com.poly.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    public String login1() {
        return "account/login";
    }

    @PostMapping("/login")
    public String login2() {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        if (un.equals("poly") && pw.equals("123")) {
            sessionService.set("username", un);
            if (rm) {
                cookieService.add("user", un, 24 * 10);
            } else {
                cookieService.remove("user");
            }
            return "redirect:/item/index";
        } else {
            return "account/login";
        }
    }

    @GetMapping("/register")
    public String register1() {
        return "/account/register";
    }
    @PostMapping("/register")
    public String register2(Model model, @RequestParam("image") MultipartFile file) {
        try {
            String username = paramService.getString("username", "");
            String password = paramService.getString("password", "");

            File savedFile = paramService.save(file, "/uploads");

            if (savedFile != null&&!username.trim().isEmpty()&&!password.trim().isEmpty()) {
                model.addAttribute("message",
                        "Đăng ký thành công! Ảnh đã lưu tại: " + savedFile.getAbsolutePath());
            } else {
                model.addAttribute("message", "Không đủ thông tin!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi: " + e.getMessage());
        }

        return "/account/register";
    }
}
