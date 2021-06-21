package com.javatraining.springchat.service;

import com.javatraining.springchat.model.User;
import com.javatraining.springchat.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> getUsersByQuery(String text) {
        return userRepo.getAllByUsernameContainingOrNameContainingOrSurnameContaining(text, text, text);
    }
}
