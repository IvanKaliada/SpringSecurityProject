package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.entity.User;
import com.gmail.iikaliada.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String createNewUser(User user) {
        userService.createNewUser(user);
        return "info";
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @GetMapping("/blocked")
    public List<User> getBlockedUsers() {
        return userService.findBlockedUsers();
    }

}
