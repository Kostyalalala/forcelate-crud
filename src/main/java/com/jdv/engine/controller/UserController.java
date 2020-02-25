package com.jdv.engine.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdv.engine.db.model.enums.Color;
import com.jdv.engine.dto.UserDTO;
import com.jdv.engine.service.CustomUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final CustomUserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    @GetMapping("/age/{age}")
    public List<UserDTO> getUsersByAge(@PathVariable("age") Integer age) {
        return userService.getUsersByAge(age);
    }

    @GetMapping("/color/{color}")
    public List<UserDTO> getUsersByArticleColor(@PathVariable("color") String color) {
        return userService.getUsersByArticleColor(Color.valueOf(color.toUpperCase()));

    }

    @GetMapping("/name")
    public List<String> getUsersByArticleCount() {
        return userService.getDistinctUsersWithArticles();

    }

}