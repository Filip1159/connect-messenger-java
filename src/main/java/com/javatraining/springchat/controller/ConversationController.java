package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.User;
import com.javatraining.springchat.model.dto.ConversationDTO;
import com.javatraining.springchat.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversations")
@RequiredArgsConstructor
public class ConversationController {
    private final ConversationService conversationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{userId}")
    public List<ConversationDTO> getConversations(@PathVariable long userId) {
        User u = new User();
        u.setUserId(userId);
        return conversationService.getUserConversations(u);
    }

    @GetMapping("/conv/{convId}")
    public ConversationDTO getConversationByUserId(@PathVariable long convId) {
        return conversationService.getConversationById(convId);
    }
}
