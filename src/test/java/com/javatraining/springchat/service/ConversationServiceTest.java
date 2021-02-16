package com.javatraining.springchat.service;

import com.javatraining.springchat.model.Conversation;
import com.javatraining.springchat.model.Participant;
import com.javatraining.springchat.repository.ConversationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConversationServiceTest {
    @Autowired
    private ConversationRepository conversationRepository;
    @Test
    public void shouldGetSingleConversation() {
        //given
        //when
        Conversation conversation = conversationRepository.getConversationByConversationId(1);
        //then
        Assertions.assertThat(conversation).isNotNull();
        Assertions.assertThat(conversation.getConversationId()).isEqualTo(1L);
    }

}