package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;
    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam String username, @RequestParam String email, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthday, @RequestParam String password1, @RequestParam String password2) {
        if (!password1.equals(password2)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords do not match");
        }

        Instant birthdayInstant = birthday.atStartOfDay(ZoneId.systemDefault()).toInstant();

        User user = new User();
        user.setName(username);
        user.setEmail(email);
        user.setBirthday(birthdayInstant);
        user.setPassword(password1);

        userService.saveUser(user);

        return "redirect:/";
    }
}
