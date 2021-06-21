package com.javatraining.springchat.model.dto;

import com.javatraining.springchat.model.Message;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ConversationDTO {
    private final long conversationId;
    private final List<Message> messages;
    private final List<UserDTO> users;
}
