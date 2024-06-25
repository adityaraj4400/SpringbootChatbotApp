package com.example.demo.controller;

import com.example.demo.model.userdetail;
import com.example.demo.repository.repository;
import com.example.demo.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class controller {
    @Autowired
    private service userService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        userdetail user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("role", user.getRole());
            if ("user".equalsIgnoreCase(user.getRole())) {
                return "redirect:/userlogin";
            } else if ("admin".equalsIgnoreCase(user.getRole())) {
                return "redirect:/adminlogin";
            } else if ("superadmin".equalsIgnoreCase(user.getRole())) {
                return "redirect:/superadminlogin";
            }
        }
        else {
            model.addAttribute("error", "Invalid credentials");

        }

        return "login";
    }



    @GetMapping("/forgotpassword")
    public String forgotPassword(Model model) {
        return "forgotpassword";
    }
    @GetMapping("/userlogin")
    public String userLogin(Model model) {
        return "userlogin";
    }

    @GetMapping("/adminlogin")
    public String adminLogin(Model model) {
        return "adminlogin";
    }

    @GetMapping("/superadminlogin")
    public String superAdminLogin(Model model) {
        return "superadminlogin";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }


}
