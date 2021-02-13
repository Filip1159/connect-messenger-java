package com.javatraining.springchat.controller;

import com.javatraining.springchat.config.LoginCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {

    }
}
