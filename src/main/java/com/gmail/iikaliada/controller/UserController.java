package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.entity.User;
import com.gmail.iikaliada.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public String createNewUser(User user) {
        userService.createNewUser(user);
        return "info";
    }

    @GetMapping("/users")
    public String registration() {
        return "registration";
    }

}
