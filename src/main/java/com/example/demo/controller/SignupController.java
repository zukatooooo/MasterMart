package com.example.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Controller
public class SignupController {
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam String username, @RequestParam String email, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthday, @RequestParam String password1, @RequestParam String password2) {
        Instant birthdayInstant = birthday.atStartOfDay(ZoneId.systemDefault()).toInstant();

        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Birthday: " + birthdayInstant);
        System.out.println("Password1: " + password1);
        System.out.println("Password2: " + password1);

        return "redirect:/";
    }
}
