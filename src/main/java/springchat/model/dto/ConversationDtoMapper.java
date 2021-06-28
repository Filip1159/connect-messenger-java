package springchat.model.dto;

import springchat.model.Conversation;

import java.util.List;
import java.util.stream.Collectors;

public class ConversationDtoMapper {
    private ConversationDtoMapper() {}
    public static List<ConversationDTO> mapToConvDTOs(List<Conversation> conversations) {
        return conversations.stream()
                .map(ConversationDtoMapper::mapToConvDTO)
                .collect(Collectors.toList());
    }
    public static ConversationDTO mapToConvDTO(Conversation c) {
        return ConversationDTO.builder()
                .conversationId(c.getConversationId())
                .messages(c.getMessages())
                .users(UserDtoMapper.mapToUserDTOs(c.getUsers()))
                .seenMapList(c.getSeenMapList())
                .build();
    }
}
