package springchat.model.dto;

import springchat.model.Message;
import lombok.Builder;
import lombok.Getter;
import springchat.model.SeenMap;

import java.util.List;

@Getter
@Builder
public class ConversationDTO {
    private final long conversationId;
    private final List<Message> messages;
    private final List<UserDTO> users;
    private final List<SeenMap> seenMapList;
}
