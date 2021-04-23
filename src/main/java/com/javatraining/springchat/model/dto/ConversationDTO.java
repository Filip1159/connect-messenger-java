package com.javatraining.springchat.model.dto;

import com.javatraining.springchat.model.Message;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ConversationDTO {
    private long conversationId;
    private List<Message> messages;
    private List<UserDTO> users;
}
