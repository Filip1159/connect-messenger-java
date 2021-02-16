package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.Message;
import com.javatraining.springchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    @GetMapping("/message/{id}")
    public Message getMessageById(@PathVariable long id) {
        Assert.notNull(messageService, "Message service is null");
        System.out.println("id = " + id);
        Message m = messageService.getMessageById(id);
        Assert.notNull(m, "Message is null");
        return m;
    }
}
