package com.gmail.iikaliada.controller;

import com.gmail.iikaliada.entity.User;
import com.gmail.iikaliada.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SecurityInfoController {

    private final UserService userService;

    @GetMapping({"/", "/info"})
    public String getInfo() {
        return "Info";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/users/blocked")
    public List<User> getBlockedUsers() {
        return userService.findBlockedUsers();
    }
}
