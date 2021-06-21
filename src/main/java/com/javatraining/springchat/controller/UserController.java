package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.User;
import com.javatraining.springchat.model.dto.UserDTO;
import com.javatraining.springchat.model.dto.UserDtoMapper;
import com.javatraining.springchat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{text}")
    public List<UserDTO> getUsersByQuery(@PathVariable String text) {
        List<User> users = userService.getUsersByQuery(text);
        return UserDtoMapper.mapToUserDTOs(users);

    }
}
