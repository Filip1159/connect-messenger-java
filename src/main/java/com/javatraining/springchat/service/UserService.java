package com.javatraining.springchat.service;

import com.javatraining.springchat.model.User;
import com.javatraining.springchat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User getUserByUsernameContains(String text) {
        return userRepository.getUserByUsernameContaining(text);
    }
}
