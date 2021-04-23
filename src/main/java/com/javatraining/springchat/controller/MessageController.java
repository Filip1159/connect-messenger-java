package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.Message;
import com.javatraining.springchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    @GetMapping("/message/{id}")
    public Message getMessageById(@PathVariable long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @GetMapping("/conversation/messages/{id}")
    public List<Message> getMessagesByConversationId(@PathVariable long id) {
        return messageService.getMessagesByConversationId(id);
    }
}
