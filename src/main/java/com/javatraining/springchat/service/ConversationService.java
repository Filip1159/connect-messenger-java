package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Conversation;
import com.javatraining.springchat.model.User;
import com.javatraining.springchat.model.dto.ConversationDTO;
import com.javatraining.springchat.model.dto.ConversationDtoMapper;
import com.javatraining.springchat.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public List<ConversationDTO> getUserConversations(User user) {
        List<Conversation> convs = conversationRepository.findConversationsByUsersContaining(user);
        return ConversationDtoMapper.mapToConvDTOs(convs);
    }
}
