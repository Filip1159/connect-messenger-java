package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.User;
import com.javatraining.springchat.model.dto.ConversationDTO;
import com.javatraining.springchat.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConversationController {
    private final ConversationService conversationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/conversations/{userId}")
    public List<ConversationDTO> getConversations(@PathVariable long userId) {
        User u = new User();
        u.setUserId(userId);
        return conversationService.getUserConversations(u);
    }
}
