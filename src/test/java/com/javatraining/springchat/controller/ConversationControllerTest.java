package com.javatraining.springchat.controller;

import com.javatraining.springchat.model.dto.ConversationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConversationControllerTest {
    @Autowired
    private ConversationController conversationController;
    @Test
    public void shouldReturnJohnsConversations() {
        List<ConversationDTO> convs = conversationController.getConversations(1);
        System.out.println(convs);
        assertThat(convs.size()).isEqualTo(3);
        assertThat(convs.get(0).getMessages().get(0).getContent()).isEqualTo("Hey John, whats up?");
        assertThat(convs.get(1).getMessages().get(0).getContent()).isEqualTo("Czesc Jan, co tam?");
    }

}