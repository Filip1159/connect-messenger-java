package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.Conversation;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConversationController {

    @GetMapping("/conversations")
    public List<Conversation> getConversations(@AuthenticationPrincipal UsernamePasswordAuthenticationToken token) {
        //TODO write service
        return null;
    }
}
