package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Conversation;
import com.javatraining.springchat.model.User;
import com.javatraining.springchat.model.dto.ConversationDTO;
import com.javatraining.springchat.model.dto.ConversationDtoMapper;
import com.javatraining.springchat.repository.ConversationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversationService {
    private final ConversationRepo conversationRepo;

    public ConversationDTO getConversationById(long convId) {
        Conversation c = conversationRepo.findById(convId).orElse(null);
        if(c == null) return null;
        return ConversationDtoMapper.mapToConvDTO(c);
    }

    public List<ConversationDTO> getUserConversations(User user) {
        List<Conversation> convs = conversationRepo.findConversationsByUsersContaining(user);
        return ConversationDtoMapper.mapToConvDTOs(convs);
    }
}
