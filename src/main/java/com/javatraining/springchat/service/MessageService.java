package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Message;
import com.javatraining.springchat.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Message getMessageById(long id) {
        return messageRepository.getMessageByMessageId(id);
    }

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    @Transactional
    public List<Message> getMessagesByConversationId(long conversationId) {
        List<Message> messages = messageRepository.getMessagesByConversationId(conversationId);
        messages.forEach(message ->   message.setWasRead(true)  );
        return messages;
    }
}
