package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.Conversation;
import com.javatraining.springchat.service.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @GetMapping("/conversations")
    public List<Conversation> getConversations(
            @RequestParam long userId,
            @AuthenticationPrincipal UsernamePasswordAuthenticationToken token
    ) {
        //String username = token.getName();
        //String s2 = token.toString();
        //System.out.println(username != null ? username : "nUlL" + s2 != null ? s2 : "nUlL");
        return conversationService.getConversationsByUserId(userId);
    }
}
