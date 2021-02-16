package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Conversation;
import com.javatraining.springchat.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private ConversationRepository conversationRepository;
    public Conversation getConversationById(long id) {
        return conversationRepository.getConversationByConversationId(id);
    }
}
