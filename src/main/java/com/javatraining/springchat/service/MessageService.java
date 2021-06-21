package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Message;
import com.javatraining.springchat.repository.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;

    public Message getMessageById(long id) {
        return messageRepo.getMessageByMessageId(id);
    }

    public Message addMessage(Message message) {
        return messageRepo.save(message);
    }
}
