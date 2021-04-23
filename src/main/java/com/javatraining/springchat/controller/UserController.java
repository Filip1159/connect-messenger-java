package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.User;
import com.javatraining.springchat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{text}")
    public User getUserByUsernameContains(@PathVariable String text) {
        return userService.getUserByUsernameContains(text);
    }
}
