package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.Message;
import com.javatraining.springchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    @GetMapping("/message/{id}")
    public Message getMessageById(@PathVariable long id) {
        return messageService.getMessageById(id);
    }
}
