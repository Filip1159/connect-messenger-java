package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Message;
import com.javatraining.springchat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    public Message getMessageById(long id) {
        return messageRepository.getMessageByMessageId(id);
    }
}
