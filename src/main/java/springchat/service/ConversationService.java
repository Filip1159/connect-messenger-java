package springchat.service;

import springchat.model.Conversation;
import springchat.model.User;
import springchat.model.dto.ConversationDTO;
import springchat.model.dto.ConversationDtoMapper;
import springchat.repository.ConversationRepo;
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
        List<Conversation> conversations = conversationRepo.findConversationsByUsersContaining(user);
        return ConversationDtoMapper.mapToConvDTOs(conversations);
    }
}
