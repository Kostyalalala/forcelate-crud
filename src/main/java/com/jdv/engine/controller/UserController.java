package com.jdv.engine.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdv.engine.db.model.User;
import com.jdv.engine.db.model.enums.Color;
import com.jdv.engine.service.CustomUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final CustomUserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/age/{age}")
    public List<User> getUsersByAge(@PathVariable("age") Integer age) {
        return userService.getUsersByAge(age);
    }

    @GetMapping("/color/{color}")
    public List<User> getUsersByArticleColor(@PathVariable("color") Color color) {
        return userService.getUsersByArticleColor(color);

    }

    @GetMapping("/name")
    public List<String> getUsersByArticleCount() {
        return userService.getDistinctUsersWithArticles();

    }

}